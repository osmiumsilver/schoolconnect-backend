package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data
public class Class {
    private Integer classNo; // 班级编号
    private String className; // 班级名称
    private Integer departmentNo; // 部门编号
    private String currentTeacherName; // 当前班主任
    private Integer currentTeacherNo; // 当前班主任编号
    private String currentInstructorName; // 当前辅导员
    private Integer currentInstructorNo; // 当前辅导员编号

}