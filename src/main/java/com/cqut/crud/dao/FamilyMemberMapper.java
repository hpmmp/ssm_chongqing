package com.cqut.crud.dao;

import com.cqut.crud.bean.FamilyMember;
import com.cqut.crud.bean.FamilyMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FamilyMemberMapper {
    long countByExample(FamilyMemberExample example);

    int deleteByExample(FamilyMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    List<FamilyMember> selectByExample(FamilyMemberExample example);

    FamilyMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FamilyMember record, @Param("example") FamilyMemberExample example);

    int updateByExample(@Param("record") FamilyMember record, @Param("example") FamilyMemberExample example);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);

    List<FamilyMember> selectByCondition(FamilyMember familyMember);
}