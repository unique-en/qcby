package com.qcby.entity;

public class XuanzeAnalysis {
    private Integer id;

    private Integer tiId;

    private String correctRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }

    public String getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(String correctRate) {
        this.correctRate = correctRate == null ? null : correctRate.trim();
    }
}