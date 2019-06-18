package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Student{
    private Integer id;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})", message = "用户名必须为2-5位中文或者6-16位英文数字下划线短横线的组合")
    private String name;

    private Integer gender;

    private String idNumber;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    private String guardianRelation;

    private String guardianName;

    private String guardianIdNumber;

    private String polity;

    private String nation;

    private String phone;

    private String linkman;

    private String linkmanPhone;

    private String censusRegister;

    private String address;

    private String postcode;

    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "邮箱格式不正确")
    private String email;

    private String qq;

    private String password;

    private String from;

    private Date deletedAt;

    private String povertyType;

    private String familyPovertyDesc;

    public Student() {
    }

    public Student(Integer id, @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})", message = "用户名必须为2-5位中文或者6-16位英文数字下划线短横线的组合") String name, Integer gender, String idNumber, Date birthday, String guardianRelation, String guardianName, String guardianIdNumber, String polity, String nation, String phone, String linkman, String linkmanPhone, String censusRegister, String address, String postcode, @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "邮箱格式不正确") String email, String qq, String password, String from, Date deletedAt, String povertyType, String familyPovertyDesc) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.idNumber = idNumber;
        this.birthday = birthday;
        this.guardianRelation = guardianRelation;
        this.guardianName = guardianName;
        this.guardianIdNumber = guardianIdNumber;
        this.polity = polity;
        this.nation = nation;
        this.phone = phone;
        this.linkman = linkman;
        this.linkmanPhone = linkmanPhone;
        this.censusRegister = censusRegister;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        this.qq = qq;
        this.password = password;
        this.from = from;
        this.deletedAt = deletedAt;
        this.povertyType = povertyType;
        this.familyPovertyDesc = familyPovertyDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianIdNumber() {
        return guardianIdNumber;
    }

    public void setGuardianIdNumber(String guardianIdNumber) {
        this.guardianIdNumber = guardianIdNumber;
    }

    public String getPolity() {
        return polity;
    }

    public void setPolity(String polity) {
        this.polity = polity;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getCensusRegister() {
        return censusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        this.censusRegister = censusRegister;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getPovertyType() {
        return povertyType;
    }

    public void setPovertyType(String povertyType) {
        this.povertyType = povertyType;
    }

    public String getFamilyPovertyDesc() {
        return familyPovertyDesc;
    }

    public void setFamilyPovertyDesc(String familyPovertyDesc) {
        this.familyPovertyDesc = familyPovertyDesc;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", idNumber='" + idNumber + '\'' +
                ", birthday=" + birthday +
                ", guardianRelation='" + guardianRelation + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianIdNumber='" + guardianIdNumber + '\'' +
                ", polity='" + polity + '\'' +
                ", nation='" + nation + '\'' +
                ", phone='" + phone + '\'' +
                ", linkman='" + linkman + '\'' +
                ", linkmanPhone='" + linkmanPhone + '\'' +
                ", censusRegister='" + censusRegister + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", password='" + password + '\'' +
                ", from='" + from + '\'' +
                ", deletedAt=" + deletedAt +
                ", povertyType='" + povertyType + '\'' +
                ", familyPovertyDesc='" + familyPovertyDesc + '\'' +
                '}';
    }
}