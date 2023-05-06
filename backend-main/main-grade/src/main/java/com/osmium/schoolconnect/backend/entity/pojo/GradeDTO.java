package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/5/6
 * @Description
 */
@Data
@TableName("t_grade")
public class GradeDTO {
    private String id;
    private Double grade;
    private Byte awaitingRevision;
}
