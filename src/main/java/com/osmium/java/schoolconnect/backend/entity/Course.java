package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data
public class Course {
    private Integer courseNo; // 课程编号
    private String courseName; // 课程名称
    private byte courseDuration; // 课程时长
    private String courseType; // 课程类型
    private String courseDescription; // 课程描述
    private String coursePlace; // 课程地点
    private String courseStatus; // 课程状态
    private String courseTeacher; // 授课教师
    private byte courseCredits; // 学分

}