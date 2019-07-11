package com.cqut.crud.service;

import com.cqut.crud.bean.Admin;
import com.cqut.crud.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenTengfei
 * @date 2019/4/29 15:53
 **/
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String uid, String pwd) {

        Admin admin = adminMapper.adminLogin(uid,pwd);
        if(admin!=null){
            return admin;
        }else{
            return null;
        }
    }
}