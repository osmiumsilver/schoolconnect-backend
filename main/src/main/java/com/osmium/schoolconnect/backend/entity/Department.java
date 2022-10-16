package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@TableName("department")
public class Department {
    private @Id Integer departmentNo;
    private String departmentName;
    private Integer departmentManagerNo; //部门负责人编号
    private String departmentManagerName; //部分负责人姓名
}