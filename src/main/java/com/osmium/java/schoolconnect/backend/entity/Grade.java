package com.osmium.java.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@TableName("grade")
public class Grade {
    private @GeneratedValue @Id long id;
    private String userNo; //学号
    private Double grade; //成绩
    private Integer courseNo; //课程编号
}



