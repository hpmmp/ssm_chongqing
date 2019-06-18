package com.cqut.crud.controller;

import com.cqut.crud.bean.*;
import com.cqut.crud.bean.Dictionary;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.FundedProjectService;
import com.cqut.crud.service.ProjectStudentService;
import com.cqut.crud.service.ProjectTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @author ChenTengfei
 * @date 2019/5/12 15:44
 **/
@Controller
@RequestMapping("/fundedProject")
public class FundedProjectController {

    @Autowired
    FundedProjectService fundedProjectService;
    @Autowired
    ProjectTypeService projectTypeService;
    @Autowired
    DicSerivce dicSerivce;
    @Autowired
    ProjectStudentService projectStudentService;

    /**
     * 获取信息
     */
    @RequestMapping("/getFundedProjectInfo")
    @ResponseBody
    public Msg getStudentInfo(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<FundedProject> fundedProjects = fundedProjectService.getAll();

        /*对字段进行翻译*/
        for (FundedProject fundedProject : fundedProjects) {
            //状态
            fundedProject.setStatus(dicSerivce.translate("PROJECT_STATUS", fundedProject.getStatus()).getDicName());
            //学籍
            fundedProject.setPhase(dicSerivce.translate("NEED_SCHOOL_PHASE", fundedProject.getPhase()).getDicName());
            //贫困类型
            fundedProject.setType(dicSerivce.translate("POVERTY_TYPE", fundedProject.getType()).getDicName());
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(fundedProjects, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 获取带资助人数的项目信息
     */
    @RequestMapping("/getFundedProjectWithNumber")
    @ResponseBody
    public Msg getFundedProjectWithNumber(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<FundedProject> fundedProjects = fundedProjectService.getFundedProjectWithStatus();

        //翻译项目状态 查询审核完成人数
        for (FundedProject fundedProject : fundedProjects) {
            Dictionary dictionary = dicSerivce.translate("PROJECT_STATUS", fundedProject.getStatus());
            fundedProject.setStatus(dictionary.getDicName());
            List<ProjectStudent> projectStudentList = projectStudentService.selectProjectStudentWithStatus(fundedProject.getId());
            fundedProject.setProjectStudentList(projectStudentList);

        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(fundedProjects, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 模糊查询
     */
    @ResponseBody
    @RequestMapping("/findByProjectName")
    public Msg findByProjectName(@RequestParam("projectName") String projectName, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        FundedProject condition = new FundedProject();
        condition.setName(projectName);

        List<FundedProject> fundedProjects = fundedProjectService.findByCondition(condition);

        /*对字段进行翻译*/
        for (FundedProject fundedProject : fundedProjects) {
            //状态
            fundedProject.setStatus(dicSerivce.translate("PROJECT_STATUS", fundedProject.getStatus()).getDicName());
            //学籍
            fundedProject.setPhase(dicSerivce.translate("SCHOOL_PHASE", fundedProject.getPhase()).getDicName());
            //贫困类型
            fundedProject.setType(dicSerivce.translate("POVERTY_TYPE", fundedProject.getType()).getDicName());
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(fundedProjects, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 删除项目，即修改项目delete_at
     */
    @ResponseBody
    @RequestMapping(value = "deleteBy/{ids}", method = RequestMethod.PUT)
    public Msg deleteBy(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            String[] str_ids = ids.split("-");
            for (String string : str_ids) {
                fundedProjectService.deleteBy(string);
            }
        } else {
            fundedProjectService.deleteBy(ids);
        }
        return Msg.success();
    }

    /*获取下拉框*/
    @RequestMapping("/getAddDropDown")
    @ResponseBody
    public Msg getAddDropDown() {
        List<ProjectType> projectTypes = projectTypeService.getEnableStatus();
        List<String> dicType = new ArrayList<>();
        dicType.add("NEED_SCHOOL_PHASE");
        dicType.add("POVERTY_TYPE");
        List<Dictionary> list = dicSerivce.getDictionaries(dicType);
        return Msg.success().add("dictionaries", list).add("projectTypes", projectTypes);
    }

    /*获取下拉框*/
    @RequestMapping("/getUpdateDropDown")
    @ResponseBody
    public Msg getUpdateDropDown() {
        List<ProjectType> projectTypes = projectTypeService.getAll();
        List<String> dicType = new ArrayList<>();
        dicType.add("NEED_SCHOOL_PHASE");
        dicType.add("POVERTY_TYPE");
        dicType.add("PROJECT_STATUS");
        List<Dictionary> list = dicSerivce.getDictionaries(dicType);
        return Msg.success().add("dictionaries", list).add("projectTypes", projectTypes);
    }

    /**
     * 信息保存
     */
    @ResponseBody
    @RequestMapping("/addProject")
    public Msg addProject(@Valid FundedProject fundedProject, @RequestParam("userId") String userId, BindingResult result) {
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
            fundedProject.setUserId(Integer.parseInt(userId));
            fundedProject.setCreatAt(new Date());
            fundedProject.setStatus("0");
            fundedProjectService.addProject(fundedProject);
            return Msg.success();
        }
    }

    /**
     * 编辑获取信息
     */
    @ResponseBody
    @RequestMapping(value = "getProjectInfo/{id}", method = RequestMethod.GET)
    public Msg getProjectInfo(@PathVariable("id") String id) {
        FundedProject project = fundedProjectService.getProjectInfo(id);
        return Msg.success().add("project", project);
    }

    /**
     * 资助项目更新
     */
    @ResponseBody
    @RequestMapping("/updateProjectStatus")
    public Msg updateProjectStatus(@RequestParam("projectId") String projectId) {
        Msg msg = fundedProjectService.updateProjectStatus(projectId);
        return msg;

    }

    //获取资助项目信息
    @ResponseBody
    @RequestMapping("/getFundedProject")
    public Msg getFundedProject(@RequestParam("projectId") String projectId) {
        FundedProject fundedProject = fundedProjectService.getFundedProject(projectId);
        //翻译项目状态
        Dictionary project_status = dicSerivce.translate("PROJECT_STATUS", fundedProject.getStatus());
        if (project_status != null) {
            fundedProject.setStatus(project_status.getDicName());
        }
        return Msg.success().add("fundedProject", fundedProject);
    }

    /**
     * 获取信息
     */
    @RequestMapping("/getApplicationStatus")
    @ResponseBody
    public Msg getApplicationStatus(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<FundedProject> fundedProjects = fundedProjectService.getApplicationStatus();

        /*对字段进行翻译*/
        for (FundedProject fundedProject : fundedProjects) {
            //状态
            fundedProject.setStatus(dicSerivce.translate("PROJECT_STATUS", fundedProject.getStatus()).getDicName());
            //学籍
            fundedProject.setPhase(dicSerivce.translate("NEED_SCHOOL_PHASE", fundedProject.getPhase()).getDicName());
            //贫困类型
            fundedProject.setType(dicSerivce.translate("POVERTY_TYPE", fundedProject.getType()).getDicName());
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(fundedProjects, 5);
        return Msg.success().add("pageInfo", page);
    }
}