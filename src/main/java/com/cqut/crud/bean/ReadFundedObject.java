package com.cqut.crud.bean;

/**
 * @author ChenTengfei
 * @date 2019/6/1 16:31
 **/
public class ReadFundedObject {
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }



    @Override
    public String toString() {
        return "ReadFundedObject{" +
                "studentId='" + studentId + '\'' +
                '}';
    }
}
