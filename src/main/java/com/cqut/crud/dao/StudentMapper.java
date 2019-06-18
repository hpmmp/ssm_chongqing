package com.cqut.crud.dao;

import com.cqut.crud.bean.Student;
import com.cqut.crud.bean.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByCondition(Student record);

    Student selectByIdNumber(String idNumber);

    int selectMaxId();

    Student studentLogin(@Param("uid")String uid, @Param("pwd")String pwd);

    Student isExist(Student conditon);
}