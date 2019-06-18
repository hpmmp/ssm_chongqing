package com.cqut.crud.dao;

import com.cqut.crud.bean.ProjectStudent;
import com.cqut.crud.bean.ProjectStudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectStudentMapper {
    long countByExample(ProjectStudentExample example);

    int deleteByExample(ProjectStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectStudent record);

    int insertSelective(ProjectStudent record);

    List<ProjectStudent> selectByExample(ProjectStudentExample example);

    ProjectStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectStudent record, @Param("example") ProjectStudentExample example);

    int updateByExample(@Param("record") ProjectStudent record, @Param("example") ProjectStudentExample example);

    int updateByPrimaryKeySelective(ProjectStudent record);

    int updateByPrimaryKey(ProjectStudent record);

    ProjectStudent selectByIds(@Param("studentId") int studentId, @Param("projectId") int projectId);

    List<ProjectStudent> selectWithProject(int parseInt);

    List<ProjectStudent> selectWithProjectAndStudent(int parseInt);

    ProjectStudent getLook(int parseInt);

    List<ProjectStudent> getPassedFundedObjects(int parseInt);

    List<ProjectStudent> selectWithStudentStatusAndStudent(int parseInt);

    List<ProjectStudent> selectProjectStudentWithStatus(Integer id);
}