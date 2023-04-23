package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author
 * @Date 2023/3/6
 * @Description
 */

@Data

public class GradeRevisionDTO {
    @TableId
    private String id;
    private Byte awaitingRevision;

}
