package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;


@Data
@TableName("grade")
public class Grade {
    private @Id long id;
    private String userNo; //学号
    private Double grade; //成绩
    private Integer courseNo; //课程编号
}



