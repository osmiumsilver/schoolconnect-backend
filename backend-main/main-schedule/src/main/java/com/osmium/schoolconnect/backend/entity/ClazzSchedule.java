package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.ArrayTypeHandler;

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

    private Integer dayOfWeek;
    private Object weeks;
    private Byte startingPeriod;
private Byte lastingPeriods;
    private Integer year;
    private Byte semester;
}
