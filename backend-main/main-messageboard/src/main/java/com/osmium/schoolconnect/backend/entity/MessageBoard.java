package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author
 * @Date 2023/3/1
 * @Description
 */
@Data
@TableName("t_message_board")
public class MessageBoard {
    @TableId(value = "id", type = IdType.NONE)
    private String id;
    private String title;
    private String body;

    private String assignedDepartment;
    private String sender;
    private Byte type;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime submittedDate;

}
