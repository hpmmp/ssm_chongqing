package com.cqut.crud.dao;

import com.cqut.crud.bean.FundedProject;
import com.cqut.crud.bean.FundedProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundedProjectMapper {
    long countByExample(FundedProjectExample example);

    int deleteByExample(FundedProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundedProject record);

    int insertSelective(FundedProject record);

    List<FundedProject> selectByExample(FundedProjectExample example);

    FundedProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundedProject record, @Param("example") FundedProjectExample example);

    int updateByExample(@Param("record") FundedProject record, @Param("example") FundedProjectExample example);

    int updateByPrimaryKeySelective(FundedProject record);

    int updateByPrimaryKey(FundedProject record);

    List<FundedProject> selectByWithType();

    List<FundedProject> selectByCondition(FundedProject fundedProject);

    List<FundedProject> selectByWithStatus();

    List<FundedProject> getPublicityFundedProject();

    List<FundedProject> selectApplicationStatus();
}