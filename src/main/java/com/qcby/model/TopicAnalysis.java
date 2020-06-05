package com.qcby.model;

import lombok.Data;

@Data
public class TopicAnalysis {
    private Integer id;

    private String project;

    private Integer type;

    private String topic;

    private String a;

    private String b;

    private String c;

    private String d;

    private String answer;

    private String parsing;

    private String difficult;

    private Double fraction;

    /**
     * 提交人数
     */
    private Integer person;

    /**
     * 正确提交人数
     */
    private Integer rig;

    /**
     * 正确率
     */
    private String correctRate;
}
