package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Generated;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author
 * @Date 2023/1/8
 * @Description
 */
@Data
@TableName("t_course_teacher")
public class CourseTeacher implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("id")
    private Long id;
    private String teacherId;//教师编号
    private String courseNo; //课程编号
}
