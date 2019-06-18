package com.cqut.crud.controller;

import com.cqut.crud.bean.Admin;
import com.cqut.crud.bean.Msg;
import com.cqut.crud.bean.Student;
import com.cqut.crud.service.AdminService;
import com.cqut.crud.service.StudentService;
import com.cqut.crud.util.AesUtil;
import com.cqut.crud.util.ParseSystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenTengfei
 * @date 2019/5/24 20:30
 **/
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;

    /**
     * 管理员登入验证
     */
    @RequestMapping("/login")
    @ResponseBody
    public Msg Login(@RequestParam("uid") String uid, @RequestParam("pwd") String pwd, HttpServletRequest request){

        //加密
        String password = "123";
        byte[] encrypt = AesUtil.encrypt(pwd, password);

        //如果想要加密内容不显示乱码，可以先将密文转换为16进制
        String hexStrResult = ParseSystemUtil.parseByte2HexStr(encrypt);

        Admin admin = adminService.login(uid,hexStrResult);
        if(null!=admin){
            request.getSession().setAttribute("u",admin);
            return Msg.success().add("identity",1);
        }else{
            Student student = studentService.login(uid,hexStrResult);
            if(null!=student){
                request.getSession().setAttribute("u",student);
                return Msg.success().add("identity",2);
            }else{
                return Msg.fail();
            }
        }
    };
}