package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@TableName("t_grade")
public class Grade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("id")
    private @Id String id;

    private String userId; //学号
    @TableField("course_no")
    private String courseNo; //课程编号
    private Double grade; //成绩
    @TableField("year")
    private int year; //学年
    @TableField("semester")
    private int semester; //学期
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime importDate; //导入时间

    @TableField("awaiting_revision")
    private byte awaitingRevision;

}


