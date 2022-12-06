package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_class")
public class Clazz  {
    @TableId("class_no")
    private String classNo; //班级编号
    private String className; //班级名称
    private String departmentNo; //部门编号
    //private String departmentName; //部门名称
    private String teacherNo; //班主任编号
    //private String teacherName; //班主任姓名
    private String instructorNo; //辅导员编号
    //private String instructorName; //辅导员姓名
    private byte classStatus; //班级状态 //
    private String schoolId;
}