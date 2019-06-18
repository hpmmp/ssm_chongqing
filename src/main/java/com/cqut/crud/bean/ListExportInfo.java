package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ChenTengfei
 * @date 2019/6/1 10:33
 **/
public class ListExportInfo {
    private String projectName;

    private String studentName;

    private String idNumber;

    private String status;

    private Double amount;

    private Double tuition;

    private String fromType;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date appliedAt;

    private String censusRegister;

    private String schoolName;

    private String schoolPhase;

    private String povertyType;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date returnedAt;

    private String noPassReason;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTuition() {
        return tuition;
    }

    public void setTuition(Double tuition) {
        this.tuition = tuition;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public Date getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(Date appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getCensusRegister() {
        return censusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        this.censusRegister = censusRegister;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolPhase() {
        return schoolPhase;
    }

    public void setSchoolPhase(String schoolPhase) {
        this.schoolPhase = schoolPhase;
    }

    public String getPovertyType() {
        return povertyType;
    }

    public void setPovertyType(String povertyType) {
        this.povertyType = povertyType;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public String getNoPassReason() {
        return noPassReason;
    }

    public void setNoPassReason(String noPassReason) {
        this.noPassReason = noPassReason;
    }

    @Override
    public String toString() {
        return "ListExportInfo{" +
                "projectName='" + projectName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", tuition=" + tuition +
                ", fromType='" + fromType + '\'' +
                ", appliedAt=" + appliedAt +
                ", censusRegister='" + censusRegister + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolPhase='" + schoolPhase + '\'' +
                ", povertyType='" + povertyType + '\'' +
                ", returnedAt=" + returnedAt +
                ", noPassReason='" + noPassReason + '\'' +
                '}';
    }
}