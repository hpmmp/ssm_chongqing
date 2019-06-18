package com.cqut.crud.service;

import com.cqut.crud.bean.FamilyMember;
import com.cqut.crud.bean.Student;
import com.cqut.crud.bean.StudentFullInfo;
import com.cqut.crud.bean.StudentStatus;
import com.cqut.crud.dao.FamilyMemberMapper;
import com.cqut.crud.dao.StudentMapper;
import com.cqut.crud.dao.StudentStatusMapper;
import com.cqut.crud.util.AesUtil;
import com.cqut.crud.util.ParseSystemUtil;
import com.cqut.crud.util.VeDate;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/23 16:10
 **/
@Service
@Transactional
public class ReadService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentStatusMapper studentStatusMapper;
    @Autowired
    private FamilyMemberMapper familyMemberMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    SqlSession sqlSession;


    public void insertStudentAndStatus(List<StudentFullInfo> studentFullInfos) throws Exception {

        List<Student> students = new ArrayList<>();
        List<StudentStatus> studentStatuses = new ArrayList<>();

        for (StudentFullInfo studentFullInfo:studentFullInfos){
            //学生密码加密
            String password = "123";
            byte[] encrypt = AesUtil.encrypt(studentFullInfo.getPassword(), password);
            //密文转换为16进制
            studentFullInfo.setPassword(ParseSystemUtil.parseByte2HexStr(encrypt));

            //组装student
            Student student = new Student();
            BeanUtils.copyProperties(studentFullInfo,student);
            student.setBirthday(VeDate.idCardToDate(student.getIdNumber()));
            students.add(student);
            //组装学籍
            StudentStatus studentStatus = new StudentStatus();
            BeanUtils.copyProperties(studentFullInfo,studentStatus);
            studentStatus.setStudentId(studentFullInfo.getId());
            if(studentFullInfo.getStartDate()!=null){
                studentStatus.setStartDate(VeDate.birthdayToDate(studentFullInfo.getStartDate()));
            }
            if(studentFullInfo.getEndDate()!=null){
                studentStatus.setStartDate(VeDate.birthdayToDate(studentFullInfo.getStartDate()));
            }
            studentStatus.setEndDate(VeDate.birthdayToDate(studentFullInfo.getEndDate()));
            studentStatuses.add(studentStatus);
        }
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        for (Student student : students) {
            studentMapper.insertSelective(student);
        }
        StudentStatusMapper studentStatusMapper = sqlSession.getMapper(StudentStatusMapper.class);
        for(StudentStatus studentStatus:studentStatuses){
            studentStatusMapper.insertSelective(studentStatus);
        }
    }

    public void insertFamilyMember(List<FamilyMember> familyMembers) {
        FamilyMemberMapper familyMemberMapper = sqlSession.getMapper(FamilyMemberMapper.class);
        for (FamilyMember familyMember : familyMembers) {
            familyMemberMapper.insertSelective(familyMember);
        }
    }
}