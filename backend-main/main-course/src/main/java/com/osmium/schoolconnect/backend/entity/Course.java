package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("t_course")
public class Course implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("course_no")
    private @Id String courseNo; //课程ID
    private String courseName; //课程名称
    private String courseNameEn; // 课程英文名词
    private Byte courseDuration; //课程时长
    private Byte courseType; //课程类型
    private String courseDesc; //课程介绍
    private String coursePlace; //课程地点
    private Byte courseStatus; //课程状态 0正常，1:结束
    private Double courseCredits; //课程学分
    private String courseTextbook; // 课程书本
    private String courseOutline;// 课程大纲
    private String courseTeacher;//课程教师
}