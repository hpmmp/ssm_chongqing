package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class FamilyMember {
    private Integer id;

    private Integer studentId;

    private String name;

    private Integer isHouseholder;

    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",message = "身份证格式错误")
    private String idNumber;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    private String relationship;

    private String education;

    private String career;

    private Double annualIncome;


    //@Pattern(regexp = "^[1](([3|5|8][\\\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\\\d]{8}$", message = "手机格式不正确")
    private String phone;

    private String remark;

    private Date deletedAt;

    public FamilyMember() {
    }

    public FamilyMember(Integer id, Integer studentId, String name, Integer isHouseholder,String idNumber, Date birthday, String relationship, String education, String career, Double annualIncome, String phone, String remark, Date deletedAt) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.isHouseholder = isHouseholder;
        this.idNumber = idNumber;
        this.birthday = birthday;
        this.relationship = relationship;
        this.education = education;
        this.career = career;
        this.annualIncome = annualIncome;
        this.phone = phone;
        this.remark = remark;
        this.deletedAt = deletedAt;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsHouseholder() {
        return isHouseholder;
    }

    public void setIsHouseholder(Integer isHouseholder) {
        this.isHouseholder = isHouseholder;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", isHouseholder=" + isHouseholder +
                ", idNumber='" + idNumber + '\'' +
                ", birthday=" + birthday +
                ", relationship='" + relationship + '\'' +
                ", education='" + education + '\'' +
                ", career='" + career + '\'' +
                ", annualIncome=" + annualIncome +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", deletedAt=" + deletedAt +
                '}';
    }
}