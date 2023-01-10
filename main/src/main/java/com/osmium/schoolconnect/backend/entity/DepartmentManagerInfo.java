package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/1/8
 * @Description
 */
@Data
@TableName("t_department_manager_info")

public class DepartmentManagerInfo {
@TableId("department_no")
    private String departmentNo;
    private String managerNo; //部门负责人编号
}
