package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/5/4
 * @Description
 */
@Data
@TableName("t_repair_data")
public class RepairDataPics {
    private String id;
    private String repairId;
    private String pictureUrl;
}
