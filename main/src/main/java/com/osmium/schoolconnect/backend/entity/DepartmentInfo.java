package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@TableName("t_department_info")
public class DepartmentInfo {
    @TableId("department_no")
    private @Id String departmentNo;
    private String departmentName;

}