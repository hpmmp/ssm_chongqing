package com.cqut.crud.controller;

import com.cqut.crud.bean.Dictionary;
import com.cqut.crud.bean.Msg;
import com.cqut.crud.bean.Student;
import com.cqut.crud.bean.StudentStatus;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.StudentService;
import com.cqut.crud.service.StudentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ChenTengfei
 * @date 2019/5/7 16:33
 **/
@Controller
@RequestMapping("/studentStatus")
public class StudentStatusController {
    @Autowired
    private StudentStatusService studentStatusService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private DicSerivce dicSerivce;

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping("/findByIdNumber")
    public Msg findByIdNumber(@RequestParam("idNumber") String idNumber) {

        if(idNumber==null){
            return Msg.fail();
        }else{
            StudentStatus studentStatus=studentStatusService.findBy(idNumber);
            //翻译学段
            Dictionary dictionary1 = dicSerivce.translate("SCHOOL_PHASE",studentStatus.getSchoolPhase());
            Dictionary dictionary2 = dicSerivce.translate("STUDENT_STATUS",studentStatus.getStatus());
            if(dictionary1!=null){
                studentStatus.setSchoolPhase(dictionary1.getDicName());
            }
            if(dictionary2!=null){
                studentStatus.setStatus(dictionary2.getDicName());
            }


            Student student=studentService.findBy(idNumber);
            return Msg.success().add("studentStatus",studentStatus).add("student",student);
        }
    }
}