package com.qcby.entity;

public class ClassInfo {
    private Integer claId;

    private String claName;

    private String claProject;

    private String claTeacid;

    public Integer getClaId() {
        return claId;
    }

    public void setClaId(Integer claId) {
        this.claId = claId;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public String getClaProject() {
        return claProject;
    }

    public void setClaProject(String claProject) {
        this.claProject = claProject == null ? null : claProject.trim();
    }

    public String getClaTeacid() {
        return claTeacid;
    }

    public void setClaTeacid(String claTeacid) {
        this.claTeacid = claTeacid == null ? null : claTeacid.trim();
    }
}