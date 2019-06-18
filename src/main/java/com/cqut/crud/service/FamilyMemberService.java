package com.cqut.crud.service;

import com.cqut.crud.bean.FamilyMember;
import com.cqut.crud.dao.FamilyMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/7 19:36
 **/
@Service
public class FamilyMemberService {

    @Autowired
    FamilyMemberMapper familyMemberMapper;

    public List<FamilyMember> getInfoByStudentId(String id) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setStudentId(Integer.parseInt(id));
        return familyMemberMapper.selectByCondition(familyMember);
    }

    public void deleteFamilyById(String id) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setId(Integer.parseInt(id));
        familyMember.setDeletedAt(new Date());
        familyMemberMapper.updateByPrimaryKeySelective(familyMember);
    }

    public void addFamilyMemberInfo(FamilyMember familyMember) {
        familyMemberMapper.insertSelective(familyMember);
    }

    public FamilyMember getFamilyMemberInfo(String id) {
        return familyMemberMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    public void updateFamilyMember(FamilyMember familyMember) {
        familyMemberMapper.updateByPrimaryKeySelective(familyMember);
    }
}