package com.cqut.crud.service;

import com.cqut.crud.bean.StudentStatus;
import com.cqut.crud.dao.StudentStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenTengfei
 * @date 2019/5/7 16:35
 **/
@Service
public class StudentStatusService {

    @Autowired
    StudentStatusMapper studentStatusMapper;

    public StudentStatus getInfoByStudentId(String id) {
        return studentStatusMapper.selectByStudentId(Integer.parseInt(id));
    }

    public StudentStatus findBy(String idNumber) {
        return studentStatusMapper.selectByIdNumber(idNumber);
    }
}