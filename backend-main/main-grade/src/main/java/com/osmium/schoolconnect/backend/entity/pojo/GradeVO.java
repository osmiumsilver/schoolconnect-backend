package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.Grade;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("v_grade_detail")
public class GradeVO extends Grade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableField("name")
    private String name;

    @TableField("course_name")
    private String courseName; //课程名称
    @TableField("course_credits")
    private byte credits; //学分


}



