package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Data
@TableName("t_user")
public class UserInfoRevisionDTO {
    @TableId(value = "id", type = IdType.NONE)
    private String id;
    private Byte requiredChanging;

}
