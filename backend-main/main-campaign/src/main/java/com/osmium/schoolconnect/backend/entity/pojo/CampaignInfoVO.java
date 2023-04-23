package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/9
 * @Description
 */
@Data
@TableName("v_campaign_info")
public class CampaignInfoVO extends CampaignInfo {
    private String campaignLauncherUsername;

}
