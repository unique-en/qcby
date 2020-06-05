package com.qcby.entity;

public class Teacher {
    private String teacId;

    private String teacName;

    private String user;

    private String teacPwd;

    private String userPhone;

    private Integer sex;

    public String getTeacId() {
        return teacId;
    }

    public void setTeacId(String teacId) {
        this.teacId = teacId == null ? null : teacId.trim();
    }

    public String getTeacName() {
        return teacName;
    }

    public void setTeacName(String teacName) {
        this.teacName = teacName == null ? null : teacName.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getTeacPwd() {
        return teacPwd;
    }

    public void setTeacPwd(String teacPwd) {
        this.teacPwd = teacPwd == null ? null : teacPwd.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}