package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data
public class Grade {
    private String id;

    private Integer userno;

    private Byte grade;

    private Integer courseno;
}