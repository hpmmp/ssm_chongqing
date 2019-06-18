package com.cqut.crud.controller;

import com.cqut.crud.bean.Dictionary;
import com.cqut.crud.bean.FundedProject;
import com.cqut.crud.bean.ListExportInfo;
import com.cqut.crud.bean.Msg;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.FundedProjectService;
import com.cqut.crud.service.ProjectStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/31 22:47
 **/
@Controller
@RequestMapping("/projectPublicity")
public class ProjectPublicityController {

    @Autowired
    FundedProjectService fundedProjectService;
    @Autowired
    ProjectStudentService projectStudentService;
    @Autowired
    DicSerivce dicSerivce;
    /**
     * 获取状态为名单公示中的资助项目
     */
    @RequestMapping("/getPublicityFundedProject")
    @ResponseBody
    public Msg getPublicityFundedProject(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<FundedProject> fundedProjects = fundedProjectService.getPublicityFundedProject();

        /*对字段进行翻译*/
        for(FundedProject fundedProject:fundedProjects){
            Dictionary dictionary1 = dicSerivce.translate("NEED_SCHOOL_PHASE",fundedProject.getPhase());
            if(dictionary1!=null){
                fundedProject.setPhase(dictionary1.getDicName());
            }
            Dictionary dictionary2 = dicSerivce.translate("PROJECT_STATUS",fundedProject.getStatus());
            if(dictionary2!=null){
                fundedProject.setStatus(dictionary2.getDicName());
            }
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(fundedProjects, 5);
        return Msg.success().add("pageInfo", page);
    }
    /**
     * 获取数据导出列表
     */
    @ResponseBody
    @RequestMapping("/getListExportInfo")
    public Msg getListExportInfo(@RequestParam("projectId") String projectId){
        List<ListExportInfo> listExportInfoList = projectStudentService.getListExportInfo(projectId);
        for(ListExportInfo listExportInfo:listExportInfoList){
            //翻译字段
            Dictionary project_student_status = dicSerivce.translate("PROJECT_STUDENT_STATUS", listExportInfo.getStatus());
            if(project_student_status!=null){
                listExportInfo.setStatus(project_student_status.getDicName());
            }
            Dictionary project_student_from_type = dicSerivce.translate("PROJECT_STUDENT_FROM_TYPE", listExportInfo.getFromType());
            if(project_student_from_type!=null){
                listExportInfo.setFromType(project_student_from_type.getDicName());
            }
            Dictionary school_phase = dicSerivce.translate("SCHOOL_PHASE", listExportInfo.getSchoolPhase());
            if(school_phase!=null){
                listExportInfo.setSchoolPhase(school_phase.getDicName());
            }
            Dictionary poverty_type = dicSerivce.translate("POVERTY_TYPE", listExportInfo.getPovertyType());
            if(poverty_type!=null){
                listExportInfo.setPovertyType(poverty_type.getDicName());
            }
        }
        return Msg.success().add("listExportInfoList",listExportInfoList);
    }
}