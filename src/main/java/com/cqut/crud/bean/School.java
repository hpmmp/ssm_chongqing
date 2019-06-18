package com.cqut.crud.bean;

public class School {
    private Integer id;

    private String code;

    private String name;

    private String type;

    private Integer ownership;

    private Integer districtType;

    public School() {
    }

    public School(Integer id, String code, String name, String type, Integer ownership, Integer districtType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.ownership = ownership;
        this.districtType = districtType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getOwnership() {
        return ownership;
    }

    public void setOwnership(Integer ownership) {
        this.ownership = ownership;
    }

    public Integer getDistrictType() {
        return districtType;
    }

    public void setDistrictType(Integer districtType) {
        this.districtType = districtType;
    }
}