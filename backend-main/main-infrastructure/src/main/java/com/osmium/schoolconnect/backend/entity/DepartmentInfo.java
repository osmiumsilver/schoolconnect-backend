package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("t_department")
public class DepartmentInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId(value = "department_no", type = IdType.AUTO)
    private String departmentNo;
    private String departmentName;

}