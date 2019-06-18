package com.cqut.crud.service;

import com.cqut.crud.bean.FundedProject;
import com.cqut.crud.bean.Msg;
import com.cqut.crud.bean.ProjectStudent;
import com.cqut.crud.bean.ProjectStudentExample;
import com.cqut.crud.dao.FundedProjectMapper;
import com.cqut.crud.dao.ProjectStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/12 15:46
 **/
@Service
public class FundedProjectService {

    @Autowired
    FundedProjectMapper fundedProjectMapper;
    @Autowired
    ProjectStudentMapper projectStudentMapper;

    public List<FundedProject> getAll() {
        return fundedProjectMapper.selectByWithType();
    }

    public List<FundedProject> findByCondition(FundedProject fundedProject) {
        return fundedProjectMapper.selectByCondition(fundedProject);
    }

    public void deleteBy(String string) {
        FundedProject fundedProject = new FundedProject();
        fundedProject.setId(Integer.parseInt(string));
        fundedProject.setDeletedAt(new Date());
        fundedProjectMapper.updateByPrimaryKeySelective(fundedProject);
    }

    public void addProject(FundedProject fundedProject) {
        fundedProjectMapper.insertSelective(fundedProject);
    }

    public FundedProject getProjectInfo(String id) {
        return fundedProjectMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    public Msg updateProjectStatus(String projectId) {
        //1查询到该资助项目信息
        FundedProject fundedProject = fundedProjectMapper.selectByPrimaryKey(Integer.parseInt(projectId));
        //更换状态
        System.out.println(fundedProject.getStatus());
        if(fundedProject.getStatus().equals("5")){
            return Msg.fail();
        }else if (fundedProject.getStatus().equals("1")) {
            fundedProject.setApplyFinishedAt(new Date());
        } else if (fundedProject.getStatus().equals("2")) {
            //3更换项目状态为名单公示中。则所有待审核的项目学生状态变为审核超时
            ProjectStudentExample example = new ProjectStudentExample();
            ProjectStudentExample.Criteria criteria = example.createCriteria();
            criteria.andProjectIdEqualTo(Integer.parseInt(projectId));
            criteria.andStatusEqualTo("1");
            List<ProjectStudent> projectStudents =projectStudentMapper.selectByExample(example);

            for(ProjectStudent projectStudent:projectStudents){
                //设置为审核超时
                projectStudent.setStatus("0");
                projectStudentMapper.updateByPrimaryKeySelective(projectStudent);
            }

            // 填入审核完成时
            fundedProject.setAuditFinishedAt(new Date());
        } else if (fundedProject.getStatus().equals("3")) {
            //4更换项目状态为资助金发放中，则填入名单公示时间完成时
            fundedProject.setPublicizeFinishedAt(new Date());
        }else if (fundedProject.getStatus().equals("4")) {
            fundedProject.setGrantFinishedAt(new Date());
        }
        fundedProject.setStatus(Integer.parseInt(fundedProject.getStatus())+1+"");
        fundedProjectMapper.updateByPrimaryKeySelective(fundedProject);
        return Msg.success();
    }

    public List<FundedProject> getFundedProjectWithStatus() {
        return fundedProjectMapper.selectByWithStatus();
    }

    public List<FundedProject> getPublicityFundedProject() {
        return fundedProjectMapper.getPublicityFundedProject();
    }

    public FundedProject getFundedProject(String projectId) {
        return fundedProjectMapper.selectByPrimaryKey(Integer.parseInt(projectId));
    }

    public List<FundedProject> getApplicationStatus() {
        return fundedProjectMapper.selectApplicationStatus();
    }
}