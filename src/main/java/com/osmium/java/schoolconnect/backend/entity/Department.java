package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data
public class Department {
    private Integer departmentNo; // 部门编号
    private String departmentName; // 部门名称
    private String departmentManager; // 负责人

}