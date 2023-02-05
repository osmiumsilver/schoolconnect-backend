package com.osmium.schoolconnect.backend.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author
 * @Date 2023/1/12
 * @Description
 */
@Data
@TableName("t_school")
public class School implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String schoolId;
    private String schoolName;
}
