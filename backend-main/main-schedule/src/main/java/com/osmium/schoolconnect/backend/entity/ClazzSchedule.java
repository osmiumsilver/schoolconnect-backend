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
    private String id;
    private String classNo;

    private String courseNo;


    private byte dayOfWeek;

    private byte period;

    private int year;
    private byte semester;
}
