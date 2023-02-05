package com.osmium.schoolconnect.backend.main.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serial;
import java.io.Serializable;


@Data
@TableName("t_grade")
public class Grade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("id")
    private @Id String id;
    private String userId; //学号
    private String courseNo; //课程编号
    private Double grade; //成绩


}



