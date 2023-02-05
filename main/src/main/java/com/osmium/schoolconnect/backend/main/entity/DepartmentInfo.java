package com.osmium.schoolconnect.backend.main.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("t_department_info")
public class DepartmentInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("department_no")
    private @Id String departmentNo;
    private String departmentName;

}