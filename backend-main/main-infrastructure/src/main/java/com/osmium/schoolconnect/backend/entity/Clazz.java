package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("t_class")
public class Clazz implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("class_no")

    private String classNo; //班级编号
    private String className; //班级名称
    private String departmentNo; //部门编号
    //private String departmentName; //部门名称
    private String year; //年份

    private Byte status; //班级状态 0默认 1毕业
}