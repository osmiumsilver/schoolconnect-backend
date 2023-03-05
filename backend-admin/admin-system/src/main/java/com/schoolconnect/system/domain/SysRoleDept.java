package com.schoolconnect.system.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色和部门关联 sys_role_dept

 */
@Data
public class SysRoleDept
{
    /** 角色ID */
    private Long roleId;
    
    /** 部门ID */
    private Long deptId;

}
