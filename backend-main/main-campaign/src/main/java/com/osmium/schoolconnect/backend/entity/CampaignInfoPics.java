package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Blob;

/**
 * @Author
 * @Date 2023/4/9
 * @Description
 */
@Data
@TableName("t_campaign_info_pics")
public class CampaignInfoPics {
    @TableId(type = IdType.NONE)
    private String id;
    private String campaignId;
    private String pictureUrl;
}
