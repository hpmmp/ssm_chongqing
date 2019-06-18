package com.cqut.crud.controller;

import com.cqut.crud.bean.*;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.ProjectStudentService;
import com.cqut.crud.service.StudentService;
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
 * @date 2019/5/26 9:52
 **/
@Controller
public class StudentModuleController {

    @Autowired
    ProjectStudentService projectStudentService;
    @Autowired
    DicSerivce dicSerivce;
    @Autowired
    StudentService studentService;

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping("/submit")
    public Msg submit(@RequestParam("studentId") String studentId, @RequestParam("projectId") String projectId) {
        Msg msg = projectStudentService.submit(studentId, projectId,"2");
        return msg;
    }


    @ResponseBody
    @RequestMapping("/myProjectStudent")
    public Msg selectMyProjectStudent(@RequestParam("studentId") String studentId, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<ProjectStudent> projectStudents = projectStudentService.selectMyProjectStudent(studentId);

        //翻译贫困类型
        for (ProjectStudent ProjectStudent : projectStudents) {
            Dictionary povertyType = dicSerivce.translate("PROJECT_STUDENT_STATUS", ProjectStudent.getStatus());
            if (povertyType != null) {
                ProjectStudent.setStatus(povertyType.getDicName());
            }
        }
        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(projectStudents, 5);
        return Msg.success().add("pageInfo", page);
    }


    //学生密码修改
    @ResponseBody
    @RequestMapping("/updatePwd")
    public Msg updatePwd(Password password, @RequestParam("studentId") String studentId) {

        Msg msg = new Msg();

        if(!password.getModify().equals(password.getConfirm())){
            msg.setCode(200);
            msg.setMsg("确认密码不一致");
            return msg;
        }else{
            Msg flag = studentService.updatePwd(password,studentId);
            if(flag.getCode()==100){
                return Msg.success();
            }else {
                msg.setCode(200);
                msg.setMsg("密码输入错误");
                return msg;
            }
        }
    }

}