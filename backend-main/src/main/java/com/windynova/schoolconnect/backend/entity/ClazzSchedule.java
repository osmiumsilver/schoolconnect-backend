package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@Data
@TableName("t_class_schedule")
public class ClazzSchedule implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    @TableField("class_id")
    private String classId;

    @TableField("course_no")
    private String courseNo;

    @TableField("weeks")
    private byte weeks;

    @TableField("lessons")
    private byte lessons;
}
