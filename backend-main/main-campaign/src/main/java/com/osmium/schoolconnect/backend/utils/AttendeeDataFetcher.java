package com.osmium.schoolconnect.backend.utils;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @Author
 * @Date 2023/4/9
 * @Description
 */
@DgsComponent
@RequiredArgsConstructor
public class AttendeeDataFetcher {
    private final ICampaignAttendeeService iCampaignAttendeeService;

    @DgsQuery
    public Collection<CampaignAttendee> actorList() {
        return iCampaignAttendeeService.list();
    }

}
