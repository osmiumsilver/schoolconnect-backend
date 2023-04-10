package com.osmium.schoolconnect.backend.entity.pojo;

import lombok.Data;

/**
 * @Author
 * @Date 2023/4/7
 * @Description
 */
@Data
public class CampaignStatusVO {
    private Boolean isStarted;
    private Boolean amISignedUp;
    private Boolean amICheckedIn;
}
