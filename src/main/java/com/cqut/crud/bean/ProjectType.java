package com.cqut.crud.bean;

public class ProjectType {
    private Integer id;

    private String name;

    private String description;

    private String frequency;

    private String level;

    private String status;

    public ProjectType() {
    }

    public ProjectType(Integer id, String name, String description, String frequency, String level, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.level = level;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "ProjectType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", frequency='" + frequency + '\'' +
                ", level='" + level + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}