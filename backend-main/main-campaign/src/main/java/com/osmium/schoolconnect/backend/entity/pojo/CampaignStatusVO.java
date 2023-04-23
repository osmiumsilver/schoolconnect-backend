package com.osmium.schoolconnect.backend.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/7
 * @Description
 */
@Data
@AllArgsConstructor
public class CampaignStatusVO {
    private String attendantId;
    private Boolean isStarted;
    private Boolean amISignedUp;
    private Boolean amICheckedIn;
}
