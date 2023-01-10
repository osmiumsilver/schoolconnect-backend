package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/1/8
 * @Description
 */
@Data
@TableName("t_course")
public class Course {
    @TableId("employee_id")
    private String employeeId;//参加的人员编号
    private String courseNo; //课程编号
}
