package com.cqut.crud.controller;

import com.cqut.crud.bean.Dictionary;
import com.cqut.crud.bean.Msg;
import com.cqut.crud.bean.ProjectType;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.ProjectTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenTengfei
 * @date 2019/5/10 19:43
 **/
@Controller
@RequestMapping("/projectType")
public class ProjectTypeController {
    @Autowired
    ProjectTypeService projectTypeService;
    @Autowired
    DicSerivce dicSerivce;

    /**
     * 获取贫困学生信息
     */
    @RequestMapping("/getProjectTypeInfo")
    @ResponseBody
    public Msg getProjectTypeInfo(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              Model model) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<ProjectType> projectTypes = projectTypeService.getAll();

        /*对字段进行翻译*/
        for(ProjectType projectType:projectTypes){
            Dictionary frequency = dicSerivce.translate("PROJECT_FREQUENCY", projectType.getFrequency());
            Dictionary level = dicSerivce.translate("PROJECT_LEVEL", projectType.getLevel());

            if(frequency!=null){
                projectType.setFrequency(frequency.getDicName());
            }
            if(level!=null){
                projectType.setLevel(level.getDicName());
            }
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(projectTypes, 5);
        return Msg.success().add("pageInfo", page);
    }
    /**
     * 项目分类停启用
     */
    @ResponseBody
    @RequestMapping(value = "statusChange/{ids}", method = RequestMethod.PUT)
    public Msg statusChange(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            String[] str_ids = ids.split("-");
            for (String string : str_ids) {
                projectTypeService.statusChange(string);
            }
        } else {
            projectTypeService.statusChange(ids);
        }
        return Msg.success();
    }
    /*获取项目分类频率和等级*/
    @RequestMapping("/getFrequencyAndLevel")
    @ResponseBody
    public Msg getFrequencyAndLevel() {
        List<String> dicType = new ArrayList<>();
        dicType.add("PROJECT_LEVEL");
        dicType.add("PROJECT_FREQUENCY");
        List<Dictionary> list = dicSerivce.getDictionaries(dicType);
        return Msg.success().add("dictionaries",list);
    }

    /**
     * 项目分类保存
     *
     * @param projectType
     * @return Msg
     */
    @RequestMapping(value = "/addProjectType", method = RequestMethod.POST)
    @ResponseBody
    public Msg addProjectType(@Valid ProjectType projectType, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误字段：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);

        } else {
            projectTypeService.addProjectType(projectType);
            return Msg.success();
        }
    }
    /**
     * 项目分类编辑获取信息
     */
    @ResponseBody
    @RequestMapping(value = "getProjectTypeBy/{id}", method = RequestMethod.GET)
    public Msg getProjectTypeBy(@PathVariable("id") String id) {
        ProjectType projectType=projectTypeService.getProjectTypeBy(id);
        return Msg.success().add("projectType",projectType);
    }
    /**
     * 项目分类更新
     */
    @ResponseBody
    @RequestMapping(value = "updateProjectType/{id}",method = RequestMethod.PUT)
    public Msg updateProjectType(@Valid ProjectType projectType, BindingResult result){
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误字段：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);

        } else {
            projectTypeService.updateProjectType(projectType);
            return Msg.success();
        }
    }
}