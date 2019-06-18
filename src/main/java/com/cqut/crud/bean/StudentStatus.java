package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StudentStatus {
    private Integer id;

    private String schoolPhase;

    private Integer studentId;

    private String idNumber;

    private Integer schoolId;

    private String schoolName;

    private String schoolLevel;

    private String studentCode;

    private String schoolNo;

    private String origin;

    private String majorCode;

    private String majorName;

    private Double tuition;

    private Integer schoolLength;

    private Integer enrollYear;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;

    private String from;

    private String status;

    public StudentStatus() {
    }

    public StudentStatus(Integer id, String schoolPhase, Integer studentId, String idNumber, Integer schoolId, String schoolName, String schoolLevel, String studentCode, String schoolNo, String origin, String majorCode, String majorName, Double tuition, Integer schoolLength, Integer enrollYear, Date startDate, Date endDate, String from, String status) {
        this.id = id;
        this.schoolPhase = schoolPhase;
        this.studentId = studentId;
        this.idNumber = idNumber;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolLevel = schoolLevel;
        this.studentCode = studentCode;
        this.schoolNo = schoolNo;
        this.origin = origin;
        this.majorCode = majorCode;
        this.majorName = majorName;
        this.tuition = tuition;
        this.schoolLength = schoolLength;
        this.enrollYear = enrollYear;
        this.startDate = startDate;
        this.endDate = endDate;
        this.from = from;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolPhase() {
        return schoolPhase;
    }

    public void setSchoolPhase(String schoolPhase) {
        this.schoolPhase = schoolPhase == null ? null : schoolPhase.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel == null ? null : schoolLevel.trim();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo == null ? null : schoolNo.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public Double getTuition() {
        return tuition;
    }

    public void setTuition(Double tuition) {
        this.tuition = tuition;
    }

    public Integer getSchoolLength() {
        return schoolLength;
    }

    public void setSchoolLength(Integer schoolLength) {
        this.schoolLength = schoolLength;
    }

    public Integer getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(Integer enrollYear) {
        this.enrollYear = enrollYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "StudentStatus{" +
                "id=" + id +
                ", schoolPhase='" + schoolPhase + '\'' +
                ", studentId=" + studentId +
                ", idNumber='" + idNumber + '\'' +
                ", schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", schoolLevel='" + schoolLevel + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", schoolNo='" + schoolNo + '\'' +
                ", origin='" + origin + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tuition=" + tuition +
                ", schoolLength=" + schoolLength +
                ", enrollYear=" + enrollYear +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", from='" + from + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}