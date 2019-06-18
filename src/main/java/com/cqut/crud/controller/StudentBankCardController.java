package com.cqut.crud.controller;

import com.cqut.crud.bean.Msg;
import com.cqut.crud.bean.StudentFullInfo;
import com.cqut.crud.service.StudentBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/26 16:40
 **/
@Controller
public class StudentBankCardController {

    @Autowired
    StudentBankCardService studentBankCardService;

    @RequestMapping("/opendCard")
    @ResponseBody
    public Msg opendCard(@RequestBody List<StudentFullInfo> studentFullInfos) {

        //遍历学生信息列表，为学生开卡
        studentBankCardService.opendCard(studentFullInfos);
        return Msg.success();
    }
}