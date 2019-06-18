package com.cqut.crud.dao;

import com.cqut.crud.bean.StudentBankcard;
import com.cqut.crud.bean.StudentBankcardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentBankcardMapper {
    long countByExample(StudentBankcardExample example);

    int deleteByExample(StudentBankcardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentBankcard record);

    int insertSelective(StudentBankcard record);

    List<StudentBankcard> selectByExample(StudentBankcardExample example);

    StudentBankcard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentBankcard record, @Param("example") StudentBankcardExample example);

    int updateByExample(@Param("record") StudentBankcard record, @Param("example") StudentBankcardExample example);

    int updateByPrimaryKeySelective(StudentBankcard record);

    int updateByPrimaryKey(StudentBankcard record);

    StudentBankcard selectByStudentId(int parseInt);
}