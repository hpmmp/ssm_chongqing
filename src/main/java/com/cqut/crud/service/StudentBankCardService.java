package com.cqut.crud.service;

import com.cqut.crud.bean.StudentBankcard;
import com.cqut.crud.bean.StudentFullInfo;
import com.cqut.crud.dao.StudentBankcardMapper;
import com.cqut.crud.util.RandomStringUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/26 16:52
 **/
@Service
public class StudentBankCardService {

    @Autowired
    StudentBankcardMapper studentBankcardMapper;
    @Autowired
    SqlSession sqlSession;

    public void opendCard(List<StudentFullInfo> studentFullInfos) {

        //批量插入
        StudentBankcardMapper studentBankcardMapper = sqlSession.getMapper(StudentBankcardMapper.class);
        for(StudentFullInfo studentFullInfo:studentFullInfos){
            studentBankcardMapper.insertSelective(new StudentBankcard(null,studentFullInfo.getId(),
                    studentFullInfo.getIdNumber(), RandomStringUtil.getRandomCode(19,0),"农业银行",
                    new Date(),null));
        }
    }
}