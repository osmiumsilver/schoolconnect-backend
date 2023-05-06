package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/14
 * @Description 单独列出pictures
 */
@Data
@TableName("t_campaign_info_pics")
public class CampaignInfoPicsVO {
    private String pictureUrl;
}
