package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class FundedProject {
    private Integer id;

    private Integer userId;

    private Integer projectTypeId;

    private String status;

    private Integer year;

    private Integer term;

    private String name;

    private String sponsor;

    private String description;

    private Double amount;

    private String standardComment;

    private String phase;

    private String type;

    private String limitComment;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date creatAt;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyFinishedAt;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date auditFinishedAt;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date publicizeFinishedAt;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date grantFinishedAt;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date deletedAt;

    private ProjectType projectType;

    private List<ProjectStudent> projectStudentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStandardComment() {
        return standardComment;
    }

    public void setStandardComment(String standardComment) {
        this.standardComment = standardComment;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLimitComment() {
        return limitComment;
    }

    public void setLimitComment(String limitComment) {
        this.limitComment = limitComment;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getApplyFinishedAt() {
        return applyFinishedAt;
    }

    public void setApplyFinishedAt(Date applyFinishedAt) {
        this.applyFinishedAt = applyFinishedAt;
    }

    public Date getAuditFinishedAt() {
        return auditFinishedAt;
    }

    public void setAuditFinishedAt(Date auditFinishedAt) {
        this.auditFinishedAt = auditFinishedAt;
    }

    public Date getPublicizeFinishedAt() {
        return publicizeFinishedAt;
    }

    public void setPublicizeFinishedAt(Date publicizeFinishedAt) {
        this.publicizeFinishedAt = publicizeFinishedAt;
    }

    public Date getGrantFinishedAt() {
        return grantFinishedAt;
    }

    public void setGrantFinishedAt(Date grantFinishedAt) {
        this.grantFinishedAt = grantFinishedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public List<ProjectStudent> getProjectStudentList() {
        return projectStudentList;
    }

    public void setProjectStudentList(List<ProjectStudent> projectStudentList) {
        this.projectStudentList = projectStudentList;
    }

    @Override
    public String toString() {
        return "FundedProject{" +
                "id=" + id +
                ", userId=" + userId +
                ", projectTypeId=" + projectTypeId +
                ", status='" + status + '\'' +
                ", year=" + year +
                ", term=" + term +
                ", name='" + name + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", standardComment='" + standardComment + '\'' +
                ", phase='" + phase + '\'' +
                ", type='" + type + '\'' +
                ", limitComment='" + limitComment + '\'' +
                ", creatAt=" + creatAt +
                ", applyFinishedAt=" + applyFinishedAt +
                ", auditFinishedAt=" + auditFinishedAt +
                ", publicizeFinishedAt=" + publicizeFinishedAt +
                ", grantFinishedAt=" + grantFinishedAt +
                ", deletedAt=" + deletedAt +
                ", projectType=" + projectType +
                ", projectStudentList=" + projectStudentList +
                '}';
    }
}