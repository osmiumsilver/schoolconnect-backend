package com.osmium.java.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@TableName("department")
public class Department {
    private @Id @GeneratedValue long id;
    private @Id Integer departmentNo;
    private String departmentName;
    private Integer departmentManagerNo; //部门负责人编号
    private String departmentManagerName; //部分负责人姓名
}