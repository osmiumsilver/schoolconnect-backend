package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data

public class Grade extends Course {

    private Integer courseNo;//课程号
    private String courseName;//课程名称
    private float grade;//成绩


}