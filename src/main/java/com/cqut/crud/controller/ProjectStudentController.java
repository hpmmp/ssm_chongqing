package com.cqut.crud.controller;

import com.cqut.crud.bean.*;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.ProjectStudentService;
import com.cqut.crud.service.ReadService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/28 21:01
 **/
@Controller
@RequestMapping("/fundedObject")
public class ProjectStudentController {

    @Autowired
    ProjectStudentService projectStudentService;
    @Autowired
    DicSerivce dicSerivce;
    @Autowired
    ReadService readService;

    /**
     * 跳转到studentDetail.jsp界面传递id
     */
    @RequestMapping(value = "/toFundedProjectDetail")
    @ResponseBody
    public Msg Login(@RequestParam("id") String id, HttpServletRequest request) {
        request.getSession().setAttribute("projectId", id);
        return Msg.success();
    }

    /**
     * 获取资助对象
     */
    @ResponseBody
    @RequestMapping("/getFundedObjects")
    public Msg getFundedObjects(@RequestParam("projectId") String projectId, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);

        List<ProjectStudent> projectStudents = projectStudentService.getFundedObjects(projectId);
        //翻译项目学生类型类型 和项目类型
        for(ProjectStudent projectStudent:projectStudents){
            Dictionary dictionary1 = dicSerivce.translate("PROJECT_STUDENT_STATUS", projectStudent.getStatus());
            if(dictionary1!=null){
                projectStudent.setStatus(dictionary1.getDicName());
            }
            Dictionary dictionary2 = dicSerivce.translate("PROJECT_STATUS", projectStudent.getFundedProject().getStatus());
            if(dictionary2!=null){
                projectStudent.getFundedProject().setStatus(dictionary2.getDicName());
            }
        }


        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(projectStudents, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 资助对象审核
     */
    @ResponseBody
    @RequestMapping(value = "examine/{id}",method = RequestMethod.PUT)
    public Msg examine(ProjectStudent projectStudent){
        projectStudentService.examine(projectStudent);
        return Msg.success();

    }
    /**
     * 资助对象审核
     */
    @ResponseBody
    @RequestMapping("/getLook")
    public Msg getLook(String id){
        ProjectStudent projectStudent= projectStudentService.getLook(id);
        Dictionary dictionary = dicSerivce.translate("PROJECT_STUDENT_STATUS", projectStudent.getStatus());
        projectStudent.setStatus(dictionary.getDicName());
        return Msg.success().add("projectStudent",projectStudent);

    }

    /**
     * 获取通过审核或者资助金发放完成的资助对象
     */
    @ResponseBody
    @RequestMapping("/getPassedFundedObjects")
    public Msg getPassedFundedObjects(@RequestParam("projectId") String projectId, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);

        List<ProjectStudent> projectStudents = projectStudentService.getPassedFundedObjects(projectId);

        //翻译项目学生类型类型 和项目类型
        for(ProjectStudent projectStudent:projectStudents){
            Dictionary dictionary1 = dicSerivce.translate("PROJECT_STUDENT_STATUS", projectStudent.getStatus());
            if(dictionary1!=null){
                projectStudent.setStatus(dictionary1.getDicName());
            }
            Dictionary dictionary2 = dicSerivce.translate("PROJECT_STATUS", projectStudent.getFundedProject().getStatus());
            if(dictionary2!=null){
                projectStudent.getFundedProject().setStatus(dictionary2.getDicName());
            }
        }


        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(projectStudents, 5);
        return Msg.success().add("pageInfo", page);
    }

    //导入excel读入资助对象
    @ResponseBody
    @RequestMapping("/readFundedObjectInfo")
    public Msg readFundedObjectInfo(@RequestBody String[] list) {

        int number = 0;
        try {
            for(int i=0;i<list.length-1;i++){
                //type为Excel导入
                Msg msg = projectStudentService.submit(list[i],list[list.length-1],"1");
                if(msg.getCode()==100){
                    number++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Msg.fail();
        }
        return Msg.success().add("number",number);
    }
}