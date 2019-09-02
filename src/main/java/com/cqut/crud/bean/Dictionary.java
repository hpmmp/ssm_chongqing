package com.cqut.crud.bean;

/**
 * @author ChenTengfei
 * @date 2019/5/11 14:25
 **/

/**
 * 字典表
 */
public class Dictionary {
    private Integer id;

    private String dicType;

    private String dicValue;

    private String dicName;

    public Dictionary() {
    }

    public Dictionary(Integer id, String dicType, String dicValue, String dicName) {
        this.id = id;
        this.dicType = dicType;
        this.dicValue = dicValue;
        this.dicName = dicName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }
}
