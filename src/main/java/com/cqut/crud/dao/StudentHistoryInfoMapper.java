package com.cqut.crud.dao;

import com.cqut.crud.bean.StudentHistoryInfo;
import com.cqut.crud.bean.StudentHistoryInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentHistoryInfoMapper {
    long countByExample(StudentHistoryInfoExample example);

    int deleteByExample(StudentHistoryInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentHistoryInfo record);

    int insertSelective(StudentHistoryInfo record);

    List<StudentHistoryInfo> selectByExample(StudentHistoryInfoExample example);

    StudentHistoryInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentHistoryInfo record, @Param("example") StudentHistoryInfoExample example);

    int updateByExample(@Param("record") StudentHistoryInfo record, @Param("example") StudentHistoryInfoExample example);

    int updateByPrimaryKeySelective(StudentHistoryInfo record);

    int updateByPrimaryKey(StudentHistoryInfo record);
}