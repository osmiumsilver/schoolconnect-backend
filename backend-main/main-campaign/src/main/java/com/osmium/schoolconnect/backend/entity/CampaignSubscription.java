package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/18
 * @Description
 */
@Data
@TableName("t_campaign_subscription")
public class CampaignSubscription {
    @TableId(type = IdType.AUTO)
    private String id;
    private String campaignId;
    private String openid;
}
