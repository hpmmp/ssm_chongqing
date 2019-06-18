package com.cqut.crud.dao;

import com.cqut.crud.bean.StudentStatus;
import com.cqut.crud.bean.StudentStatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentStatusMapper {
    long countByExample(StudentStatusExample example);

    int deleteByExample(StudentStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentStatus record);

    int insertSelective(StudentStatus record);

    List<StudentStatus> selectByExample(StudentStatusExample example);

    StudentStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentStatus record, @Param("example") StudentStatusExample example);

    int updateByExample(@Param("record") StudentStatus record, @Param("example") StudentStatusExample example);

    int updateByPrimaryKeySelective(StudentStatus record);

    int updateByPrimaryKey(StudentStatus record);

    StudentStatus selectByStudentId(int parseInt);

    StudentStatus selectByIdNumber(String idNumber);
}