package com.qcby.entity;

public class StuErrti {
    private Integer id;

    private String stuId;

    private Integer type;

    private Integer tiId;

    private String errAnswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }

    public String getErrAnswer() {
        return errAnswer;
    }

    public void setErrAnswer(String errAnswer) {
        this.errAnswer = errAnswer == null ? null : errAnswer.trim();
    }
}