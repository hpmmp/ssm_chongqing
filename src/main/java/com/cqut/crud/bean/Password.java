package com.cqut.crud.bean;

/**
 * @author ChenTengfei
 * @date 2019/5/27 19:43
 **/
public class Password {
    private String original;
    private String modify;
    private  String confirm;

    public Password() {
    }

    public Password(String original, String modify, String confirm) {
        this.original = original;
        this.modify = modify;
        this.confirm = confirm;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "Password{" +
                "original='" + original + '\'' +
                ", modify='" + modify + '\'' +
                ", confirm='" + confirm + '\'' +
                '}';
    }
}