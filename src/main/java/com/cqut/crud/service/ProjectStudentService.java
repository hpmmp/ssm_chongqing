package com.cqut.crud.service;

import com.cqut.crud.bean.*;
import com.cqut.crud.dao.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/26 10:10
 **/
@Service
public class ProjectStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentStatusMapper studentStatusMapper;
    @Autowired
    ProjectStudentMapper projectStudentMapper;
    @Autowired
    FundedProjectMapper fundedProjectMapper;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    StudentBankcardMapper studentBankcardMapper;
    @Autowired
    SqlSession sqlSession;
    @Autowired
    FundingInfoMapper fundingInfoMapper;
    @Autowired
    BankcardChangeRecordMapper bankcardChangeRecordMapper;


    public Msg submit(String studentId, String projectId,String type) {

        Msg msg = new Msg();

        ProjectStudent condition = projectStudentMapper.selectByIds(Integer.parseInt(studentId), Integer.parseInt(projectId));
        if (condition != null) {
            msg.setCode(200);
            msg.setMsg("请勿重复申请");
            return msg;
        }

        FundedProject exist1 = fundedProjectMapper.selectByPrimaryKey(Integer.parseInt(projectId));
        Student exist2 = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if(exist1==null||exist2==null){
            msg.setCode(200);
            msg.setMsg("学生或者项目不存在");
            return msg;
        }

        //查询学生个人信息和学籍信息,资助项目信息,学校信息,银行卡信息。
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        StudentStatus studentStatus = studentStatusMapper.selectByStudentId(Integer.parseInt(studentId));
        FundedProject fundedProject = fundedProjectMapper.selectByPrimaryKey(Integer.parseInt(projectId));
        School school = schoolMapper.selectByPrimaryKey(studentStatus.getSchoolId());
        StudentBankcard studentBankcard = studentBankcardMapper.selectByStudentId(Integer.parseInt(studentId));

        //判断是否符合资助标准
        //如果项目要求学段不限则只判断贫困类型
        if(fundedProject.getPhase().equals("0")){
            if(!fundedProject.getType().equals(student.getPovertyType())){
                msg.setCode(200);
                msg.setMsg("贫困类型不符");
                return msg;
            }
        }else{
            if (!fundedProject.getPhase().equals(studentStatus.getSchoolPhase()) || !fundedProject.getType().equals(student.getPovertyType())) {
                msg.setCode(200);
                msg.setMsg("学段或贫困类型不符");
                return msg;
            }
        }

        //组装插入项目学生表
        ProjectStudent projectStudent = new ProjectStudent();

        projectStudent.setStudentId(Integer.parseInt(studentId));
        projectStudent.setProjectId(Integer.parseInt(projectId));
        projectStudent.setIdNumber(student.getIdNumber());
        projectStudent.setSchoolRollId(studentStatus.getId());
        projectStudent.setProjectTypeId(fundedProject.getProjectTypeId());
        //待审核
        projectStudent.setStatus("1");
        projectStudent.setAmount(fundedProject.getAmount());
        projectStudent.setTuition(studentStatus.getTuition());
        //在线申请或者Excle导入
        projectStudent.setFromType(type);
        projectStudent.setAppliedAt(new Date());
        projectStudent.setCensusRegister(student.getCensusRegister());
        projectStudent.setSchoolName(school.getName());
        projectStudent.setOwnership(school.getOwnership());
        projectStudent.setSchoolPhase(studentStatus.getSchoolPhase());
        projectStudent.setPovertyType(student.getPovertyType());
        projectStudent.setBankcardId(studentBankcard.getId());

        projectStudentMapper.insertSelective(projectStudent);

        return Msg.success();
    }


    public List<ProjectStudent> selectMyProjectStudent(String studentId) {
        return projectStudentMapper.selectWithProject(Integer.parseInt(studentId));
    }

    public List<ProjectStudent> getFundedObjects(String projectId) {
        return projectStudentMapper.selectWithProjectAndStudent(Integer.parseInt(projectId));
    }

    public void examine(ProjectStudent projectStudent) {
        //如果状态为未通过，则设置退回时间
        if (projectStudent.getStatus().equals("2")) {
            projectStudent.setReturnedAt(new Date());
        }
        projectStudentMapper.updateByPrimaryKeySelective(projectStudent);
    }

    public ProjectStudent getLook(String id) {
        return projectStudentMapper.getLook(Integer.parseInt(id));
    }

    public List<ProjectStudent> getPassedFundedObjects(String projectId) {
        return projectStudentMapper.getPassedFundedObjects(Integer.parseInt(projectId));
    }

    public Msg grant(String projectId) {
        //根据项目ID查询到资助项目。
        FundedProject fundedProject = fundedProjectMapper.selectByPrimaryKey(Integer.parseInt(projectId));
        //如果该项目的状态为资助金已发放则返回提示信息
        if(fundedProject.getStatus().equals("5")){
            return Msg.fail();
        }else{
            fundedProject.setStatus("5");
            fundedProject.setGrantFinishedAt(new Date());
            fundedProjectMapper.updateByPrimaryKeySelective(fundedProject);
        }

        //根据项目ID查询到项目学生列表
        List<ProjectStudent> projectStudentList = projectStudentMapper.selectWithStudentStatusAndStudent(Integer.parseInt(projectId));
        FundingInfoMapper fundingInfoMapper = sqlSession.getMapper(FundingInfoMapper.class);
        BankcardChangeRecordMapper bankcardChangeRecordMapper = sqlSession.getMapper(BankcardChangeRecordMapper.class);
        ProjectStudentMapper projectStudentMapper = sqlSession.getMapper(ProjectStudentMapper.class);

        for(ProjectStudent projectStudent:projectStudentList){
            //组装资助记录表
            FundingInfo fundingInfo = new FundingInfo();
            fundingInfo.setProjectId(fundedProject.getId());
            fundingInfo.setProjectName(fundedProject.getName());
            fundingInfo.setStudentId(projectStudent.getStudentId());
            fundingInfo.setName(projectStudent.getStudent().getName());
            fundingInfo.setIdNumber(projectStudent.getIdNumber());
            //资助学段
            fundingInfo.setPhase(fundedProject.getPhase());
            fundingInfo.setYear(fundedProject.getYear());
            fundingInfo.setTerm(fundedProject.getTerm());
            fundingInfo.setAmount(fundedProject.getAmount());
            fundingInfo.setSchoolName(projectStudent.getSchoolName());
            fundingInfoMapper.insertSelective(fundingInfo);
            //组装银行变动记录
            BankcardChangeRecord bankcardChangeRecord = new BankcardChangeRecord();
            bankcardChangeRecord.setStudentId(projectStudent.getStudentId());
            bankcardChangeRecord.setIdNumber(projectStudent.getIdNumber());
            bankcardChangeRecord.setProjectId(projectStudent.getProjectId());
            bankcardChangeRecord.setProjectName(fundedProject.getName());
            bankcardChangeRecord.setType("2");
            bankcardChangeRecord.setBankName(projectStudent.getStudentBankcard().getBankName());
            bankcardChangeRecord.setAmount(fundedProject.getAmount());
            bankcardChangeRecordMapper.insertSelective(bankcardChangeRecord);
            //更改项目学生状态为资助金已发放
            projectStudent.setStatus("4");
            projectStudentMapper.updateByPrimaryKeySelective(projectStudent);
        }
        return Msg.success().add("number",projectStudentList.size());
    }

    public List<ProjectStudent> selectProjectStudentWithStatus(Integer id) {
        return projectStudentMapper.selectProjectStudentWithStatus(id);
    }

    public List<ListExportInfo> getListExportInfo(String id) {
        List<ProjectStudent> projectStudents = projectStudentMapper.selectWithProjectAndStudent(Integer.parseInt(id));
        List<ListExportInfo> listExportInfoList = new ArrayList<>();
        for(ProjectStudent projectStudent:projectStudents){
            ListExportInfo listExportInfo = new ListExportInfo();
            BeanUtils.copyProperties(projectStudent,listExportInfo);
            listExportInfo.setStudentName(projectStudent.getStudent().getName());
            listExportInfo.setProjectName(projectStudent.getFundedProject().getName());
            listExportInfoList.add(listExportInfo);
        }
        return listExportInfoList;
    }
}