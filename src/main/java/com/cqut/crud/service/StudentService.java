package com.cqut.crud.service;

import com.cqut.crud.bean.Msg;
import com.cqut.crud.bean.Password;
import com.cqut.crud.bean.Student;
import com.cqut.crud.bean.StudentExample;
import com.cqut.crud.dao.StudentMapper;
import com.cqut.crud.util.AesUtil;
import com.cqut.crud.util.ParseSystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/2 15:02
 **/
@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<Student> getAll() {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andDeletedAtIsNull();
        return studentMapper.selectByExample(studentExample);
    }

    public List<Student> findByCondition(Student student) {
        return studentMapper.selectByCondition(student);
    }

    public void deleteBy(String id) {
        Student student = new Student();
        student.setId(Integer.parseInt(id));
        student.setDeletedAt(new Date());
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public Student getInfoById(String id) {
        Student student=studentMapper.selectByPrimaryKey(Integer.parseInt(id));
        return student;
    }

    public void saveStudentInfo(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public Student findBy(String idNumber) {
        return studentMapper.selectByIdNumber(idNumber);
    }

    public int getMaxId() {
        return studentMapper.selectMaxId();
    }

    public Student login(String uid, String pwd) {
        Student student = studentMapper.studentLogin(uid,pwd);
        if(student!=null){
            return student;
        }else{
            return null;
        }
    }

    public Msg updatePwd(Password password, String studentId) {

        String passwordKey = "123";
        // 加密
        byte[] encrypt1 = AesUtil.encrypt(password.getOriginal(), passwordKey);
        //密文转换为16进制
        String hexStrResult1 = ParseSystemUtil.parseByte2HexStr(encrypt1);


        Student conditon = new Student();
        conditon.setId(Integer.parseInt(studentId));
        conditon.setPassword(hexStrResult1);
        Student flag = studentMapper.isExist(conditon);
        if(flag!=null){
            // 加密
            byte[] encrypt2 = AesUtil.encrypt(password.getConfirm(), passwordKey);
            //密文转换为16进制
            String hexStrResult2 = ParseSystemUtil.parseByte2HexStr(encrypt2);
            Student student = new Student();
            student.setId(Integer.parseInt(studentId));
            student.setPassword(hexStrResult2);
            studentMapper.updateByPrimaryKeySelective(student);
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }
}