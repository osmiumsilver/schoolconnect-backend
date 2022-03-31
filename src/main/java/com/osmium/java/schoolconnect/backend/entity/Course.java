package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data
public class Course {
    private Integer courseno;

    private String coursename;

    private Byte courseduration;

    private Byte coursetype;

    private String coursedesc;

    private String courseplace;

    private Byte coursestatus;

    private String courseteacher;

    private Byte coursecredits;
}