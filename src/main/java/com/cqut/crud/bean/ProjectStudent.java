package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProjectStudent {
    private Integer id;

    private Integer studentId;

    private Integer projectId;

    private String idNumber;

    private Integer schoolRollId;

    private Integer projectTypeId;

    private String status;

    private Double amount;

    private Double tuition;

    private String fromType;

    private Date appliedAt;

    private String censusRegister;

    private String schoolName;

    private Integer ownership;

    private String schoolPhase;

    private String povertyType;

    private Integer bankcardId;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date returnedAt;

    private String noPassReason;

    private FundedProject fundedProject;

    private Student student;

    private StudentStatus studentStatus;

    private StudentBankcard studentBankcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getSchoolRollId() {
        return schoolRollId;
    }

    public void setSchoolRollId(Integer schoolRollId) {
        this.schoolRollId = schoolRollId;
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

    public Integer getOwnership() {
        return ownership;
    }

    public void setOwnership(Integer ownership) {
        this.ownership = ownership;
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

    public Integer getBankcardId() {
        return bankcardId;
    }

    public void setBankcardId(Integer bankcardId) {
        this.bankcardId = bankcardId;
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

    public FundedProject getFundedProject() {
        return fundedProject;
    }

    public void setFundedProject(FundedProject fundedProject) {
        this.fundedProject = fundedProject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public StudentBankcard getStudentBankcard() {
        return studentBankcard;
    }

    public void setStudentBankcard(StudentBankcard studentBankcard) {
        this.studentBankcard = studentBankcard;
    }

    @Override
    public String toString() {
        return "ProjectStudent{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", projectId=" + projectId +
                ", idNumber='" + idNumber + '\'' +
                ", schoolRollId=" + schoolRollId +
                ", projectTypeId=" + projectTypeId +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", tuition=" + tuition +
                ", fromType='" + fromType + '\'' +
                ", appliedAt=" + appliedAt +
                ", censusRegister='" + censusRegister + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", ownership=" + ownership +
                ", schoolPhase='" + schoolPhase + '\'' +
                ", povertyType='" + povertyType + '\'' +
                ", bankcardId=" + bankcardId +
                ", returnedAt=" + returnedAt +
                ", noPassReason='" + noPassReason + '\'' +
                ", fundedProject=" + fundedProject +
                ", student=" + student +
                ", studentStatus=" + studentStatus +
                ", studentBankcard=" + studentBankcard +
                '}';
    }
}