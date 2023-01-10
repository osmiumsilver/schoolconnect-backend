package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;


@Data
@TableName("t_grade")
public class Grade {
    @TableId("id")
    private @Id String id;
    private String userId; //学号
    private Integer courseNo; //课程编号
    private Double grade; //成绩


}



