package com.cqut.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StudentBankcard {
    private Integer id;

    private Integer studentId;

    private String idNumber;

    private String cardNo;

    private String bankName;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date openedAt;

    private String remark;

    public StudentBankcard() {
    }

    public StudentBankcard(Integer id, Integer studentId, String idNumber, String cardNo, String bankName, Date openedAt, String remark) {
        this.id = id;
        this.studentId = studentId;
        this.idNumber = idNumber;
        this.cardNo = cardNo;
        this.bankName = bankName;
        this.openedAt = openedAt;
        this.remark = remark;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(Date openedAt) {
        this.openedAt = openedAt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StudentBankcard{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", idNumber='" + idNumber + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", openedAt=" + openedAt +
                ", remark='" + remark + '\'' +
                '}';
    }
}