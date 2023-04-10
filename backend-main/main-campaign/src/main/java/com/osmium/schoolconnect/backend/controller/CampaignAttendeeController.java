package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/23
 * @Description
 */
@RestController
@RequestMapping("/campaign/attendee")
@Tag(name = "活动报名")
public class CampaignAttendeeController {
    private ICampaignAttendeeService iCampaignAttendeeService;

    public CampaignAttendeeController(ICampaignAttendeeService iCampaignAttendeeService) {
        this.iCampaignAttendeeService = iCampaignAttendeeService;
    }

    @Operation(summary = "获取我参加的活动信息")
    @GetMapping("/my")
    public List<String> listCampaignsIAttended(Authentication authentication, String status) {
        return iCampaignAttendeeService.listCampaignsIAttended(authentication.getName(), status);
    }

    //@Operation(summary = "我在当前活动的状态，是否签到，是否报名，是否开始了")
    //@GetMapping("/campaignStatus")
    //public CampaignStatus getCampaignStatus(Authentication authentication, @RequestParam String campaignId, String participantId) {
    //    iCampaignAttendeeService
    //}

    @Operation(summary = "根据活动ID获取已经报名的人")
    @GetMapping("/list_attendees")
    public List<CampaignAttendee> listAttendees(@RequestParam String campaignId) {
        return iCampaignAttendeeService.listAttendees(campaignId);
    }

    @Operation(summary = "报名")
    @PostMapping
    public Boolean signForCampaign(CampaignAttendee attendee) {
        return iCampaignAttendeeService.save(attendee);
    }

    @Operation(summary = "修改报名信息")

    @PutMapping
    public Boolean modifyAttendeeInfo(CampaignAttendee attendee) {
        return iCampaignAttendeeService.updateById(attendee);
    }

    @Operation(summary = "退出报名")

    @DeleteMapping
    public Boolean signOutCampaign(CampaignAttendee attendee) {
        return iCampaignAttendeeService.removeById(attendee);
    }
}
