package com.osmium.java.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@TableName("class")
public class Clazz {
    private @Id @GeneratedValue long id; //随机生成id
    private @Id Integer classNo; //课程
    private String className; //课程名称
    private Integer departmentNo; //部门编号
    private String departmentName; //部门名称
    private Integer teacherNo; //班主任编号
    private String teacherName; //班主任姓名
    private Integer instructorNo; //辅导员编号
    private String instructorName; //辅导员姓名
}