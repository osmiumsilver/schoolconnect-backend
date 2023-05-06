package com.osmium.schoolconnect.backend.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author
 * @Date 2023/4/30
 * @Description
 */
@Data
@TableName("t_student_info")
public class StudentInfo {
    private String id; //Generated ID

    @TableId("student_id")
    @Excel(name = "工号")
    private String studentId; //工号

    @TableField("class_no")
    @Excel(name = "班级编号")
    private String classNo; //所在班级编号

    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("estimated_graduation_time")
    @Excel(name="预计毕业时间")
    private LocalDate estimatedGraduateTime;
}
