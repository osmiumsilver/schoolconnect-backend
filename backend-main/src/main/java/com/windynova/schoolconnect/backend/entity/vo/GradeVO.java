package com.osmium.schoolconnect.backend.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.Grade;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("view_name")
public class GradeVO extends Grade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("course_name")
    private String courseName; //课程名称
    @TableField("course_credits")
    private byte credits; //学分


}



