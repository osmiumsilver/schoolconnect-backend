package com.osmium.schoolconnect.backend.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author
 * @Date 2023/1/8
 * @Description
 */
@Data
@TableName("t_course")
public class Course implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;
    private String employeeId;//参加的人员编号
    private String courseNo; //课程编号
}
