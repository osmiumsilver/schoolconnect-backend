package com.schoolconnect.system.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和岗位关联 sys_user_post

 */
@Data
public class SysUserPost
{
    /** 用户ID */
    private Long userId;
    
    /** 岗位ID */
    private Long postId;

}
