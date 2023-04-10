package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Data
@TableName("t_campaign_info")
public class CampaignInfo {
    @TableId(value = "t_campaign_info.id", type = IdType.NONE)
    private String id;
    private String campaignName;
    private String campaignDescription;
    private String campaignLocation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime campaignTime;
    private String campaignLauncher;
    private String contactPhone;
    private byte campaignStatus;
    private String campaignUrl;
}
