package com.cqut.crud.bean;

public class StudentHistoryInfo {
    private Integer id;

    private Integer studentId;

    private String handle;

    private String content;

    private Integer userId;

    private String userName;

    public StudentHistoryInfo() {
    }

    public StudentHistoryInfo(Integer id, Integer studentId, String handle, String content, Integer userId, String userName) {
        this.id = id;
        this.studentId = studentId;
        this.handle = handle;
        this.content = content;
        this.userId = userId;
        this.userName = userName;
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

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}