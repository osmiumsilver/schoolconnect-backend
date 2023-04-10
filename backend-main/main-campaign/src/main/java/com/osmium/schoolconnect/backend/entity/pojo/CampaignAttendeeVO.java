package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/9
 * @Description
 */
@Data
@TableName("v_campaign_attendee")
public class CampaignAttendeeVO extends CampaignAttendee {
    private String name;
    private String pictureUrl;
}
