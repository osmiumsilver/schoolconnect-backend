package com.osmium.schoolconnect.backend.entity;

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
@TableName("t_campaign_attendees")
public class CampaignAttendee {
    @TableId(value = "id", type = IdType.NONE)
    private String id;
    private String campaignId;
    private String userId;

    private byte checkInStatus;
}

