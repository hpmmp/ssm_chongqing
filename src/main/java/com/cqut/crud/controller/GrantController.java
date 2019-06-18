package com.cqut.crud.controller;

import com.cqut.crud.bean.Msg;
import com.cqut.crud.service.ProjectStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ChenTengfei
 * @date 2019/5/30 23:07
 **/
@Controller
public class GrantController {

    @Autowired
    ProjectStudentService projectStudentService;


    @ResponseBody
    @RequestMapping("/grant")
    public Msg grant(@RequestParam("projectId") String projectId) {
        Msg msg = projectStudentService.grant(projectId);
        return msg;
    }
}