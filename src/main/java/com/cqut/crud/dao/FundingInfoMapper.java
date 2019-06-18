package com.cqut.crud.dao;

import com.cqut.crud.bean.FundingInfo;
import com.cqut.crud.bean.FundingInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundingInfoMapper {
    long countByExample(FundingInfoExample example);

    int deleteByExample(FundingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundingInfo record);

    int insertSelective(FundingInfo record);

    List<FundingInfo> selectByExample(FundingInfoExample example);

    FundingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundingInfo record, @Param("example") FundingInfoExample example);

    int updateByExample(@Param("record") FundingInfo record, @Param("example") FundingInfoExample example);

    int updateByPrimaryKeySelective(FundingInfo record);

    int updateByPrimaryKey(FundingInfo record);

}