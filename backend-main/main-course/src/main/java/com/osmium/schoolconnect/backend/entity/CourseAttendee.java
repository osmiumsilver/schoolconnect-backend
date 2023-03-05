package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_course_attendee")
public class CourseAttendee implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private String id; //生成Id
    private String attendeeId;//参加的人员编号
    private String courseNo; //课程编号
}
