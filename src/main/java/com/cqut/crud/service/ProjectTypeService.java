package com.cqut.crud.service;

import com.cqut.crud.bean.ProjectType;
import com.cqut.crud.bean.ProjectTypeExample;
import com.cqut.crud.dao.ProjectTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/10 19:43
 **/
@Service
public class ProjectTypeService {

    @Autowired
    ProjectTypeMapper projectTypeMapper;

    public void statusChange(String id) {
        /*查出该状态*/
        ProjectType projectType=projectTypeMapper.selectByPrimaryKey(Integer.parseInt(id));
        projectType.setStatus("0".equals(projectType.getStatus())?"1":"0");
        projectTypeMapper.updateByPrimaryKeySelective(projectType);
    }

    public List<ProjectType> getAll() {
        //查询状态为1，即为启用的项目分类
        return projectTypeMapper.selectByExample(null);
    }

    public void addProjectType(ProjectType projectType) {
        projectTypeMapper.insertSelective(projectType);
    }

    public ProjectType getProjectTypeBy(String id) {
        return projectTypeMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    public void updateProjectType(ProjectType projectType) {
        projectTypeMapper.updateByPrimaryKeySelective(projectType);

    }

    public List<ProjectType> getEnableStatus() {
        //查询状态为1，即为启用的项目分类
        ProjectTypeExample example = new ProjectTypeExample();
        ProjectTypeExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");
        return projectTypeMapper.selectByExample(example);
    }
}