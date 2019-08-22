package com.cqut.crud.bean;

/**
 * 这是版本错误阶段
 * 测试回退版本
 * 用户密码均使用AES算法加解密
 */
public class Admin {
    private Integer id;

    private String name;

    private String account;

    private String password;

    private String phone;

    private String email;

    public Admin() {
    }

    public Admin(Integer id, String name, String account, String password, String phone, String email) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.email = email;
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
        this.name = name == null ? null : name.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}