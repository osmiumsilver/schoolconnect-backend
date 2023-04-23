package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author
 * @Date 2023/3/10
 * @Description
 */
@Data
@TableName("t_repair_data")
public class RepairData {
    @TableId(type = IdType.NONE)
    private String id;
    private String description;

    private String phone;
    private String location;
    private Byte level;

    private Byte status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String initiator; //发起人
}
