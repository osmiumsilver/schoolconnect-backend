package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@TableName("course")
public class Course {
    private @Id Integer courseNo; //课程ID
    private String courseName; //课程名称
    private Byte courseDuration; //课程时长
    private Byte courseType; //课程类型
    private String courseDesc; //课程介绍
    private String coursePlace; //课程地点
    private Byte courseStatus; //课程状态 0正常，1:结束
    private String courseTeacher; //课程老师
    private Byte courseCredits; //课程学分
}