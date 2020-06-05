package com.qcby.entity;

public class TestPaper {
    private String testId;

    private String testTitle;

    private String testProject;

    private String date;

    private String teacherId;

    private String claName;

    private Integer isrelease;

    private String difficult;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle == null ? null : testTitle.trim();
    }

    public String getTestProject() {
        return testProject;
    }

    public void setTestProject(String testProject) {
        this.testProject = testProject == null ? null : testProject.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public Integer getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(Integer isrelease) {
        this.isrelease = isrelease;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult == null ? null : difficult.trim();
    }
}