package com.osmium.schoolconnect.backend.entity.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.osmium.schoolconnect.backend.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * @Author
 * @Date 2023/4/30
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("v_user_student")
public class StudentInfoVO extends User {

    @TableField("class_no")
    @Excel(name = "班级编号")
    private String classNo; //所在班级编号
    @TableField("class_name")
    private String className; //所在班级名称
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("estimated_graduation_time")
    @Excel(name="预计毕业时间")
    private LocalDate estimatedGraduateTime;

}
