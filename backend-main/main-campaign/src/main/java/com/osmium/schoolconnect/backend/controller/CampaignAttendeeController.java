package com.osmium.schoolconnect.backend.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.entity.CampaignSubscription;
import com.osmium.schoolconnect.backend.entity.NotificationData;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignAttendeeVO;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignStatusDTO;
import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import com.osmium.schoolconnect.backend.service.ICampaignSubscriptionService;
import com.osmium.schoolconnect.backend.utils.NotificationUtils;
import com.osmium.schoolconnect.backend.utils.annotations.AccessIsolation;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date 2023/3/23
 * @Description
 */
@RestController
@RequestMapping("/campaign/attendee")
@Tag(name = "活动报名")
public class CampaignAttendeeController {
    private final ICampaignAttendeeService iCampaignAttendeeService;
    private final ICampaignSubscriptionService iCampaignSubscriptionService;
    private final NotificationUtils notificationUtils;
    private final ICampaignInfoService iCampaignInfoService;

    public CampaignAttendeeController(ICampaignAttendeeService iCampaignAttendeeService, ICampaignSubscriptionService iCampaignSubscriptionService, NotificationUtils notificationUtils, ICampaignInfoService iCampaignInfoService) {
        this.iCampaignAttendeeService = iCampaignAttendeeService;
        this.iCampaignSubscriptionService = iCampaignSubscriptionService;
        this.notificationUtils = notificationUtils;
        this.iCampaignInfoService = iCampaignInfoService;
    }

    @Operation(summary = "获取我参加的活动信息")
    @GetMapping("/my")
    public List<String> listCampaignsIAttended(Authentication authentication, String status) {
        return iCampaignAttendeeService.listCampaignsIAttended(authentication.getName(), status);
    }

    @Operation(summary = "我在当前活动的状态，是否签到，是否报名，是否开始了")
    @GetMapping("/campaign_status")
    public CampaignStatusDTO getUserStatusOfCampaign(Authentication authentication, @RequestParam String campaignId) {
        return iCampaignAttendeeService.getUserStatusOfCampaign(authentication.getName(), campaignId);
    }

    @Operation(summary = "根据活动ID获取已经报名的人")
    @GetMapping("/list_attendees")
    public List<CampaignAttendeeVO> listAttendees(@RequestParam String campaignId) {
        return iCampaignAttendeeService.listAttendees(campaignId);
    }

    @Operation(summary = "报名")
    @PostMapping
    public Boolean signForCampaign(@RequestBody CampaignAttendee attendee) {
        return iCampaignAttendeeService.save(attendee);
    }

    @Operation(summary = "修改报名信息")

    @PutMapping
    public Boolean modifyAttendeeInfo(@RequestBody CampaignAttendee attendee) {
        return iCampaignAttendeeService.updateById(attendee);
    }

    @Operation(summary = "退出报名")
    @AccessIsolation
    @DeleteMapping
    public Boolean signOutCampaign(@RequestParam String userId, @RequestBody String id) {
        return iCampaignAttendeeService.removeById(id);
    }

    @Operation(summary = "签到签退")
    @PatchMapping("/check")
    public Boolean checkIn(Authentication authentication, @RequestParam String inOrOut, String attendantId) {
        if (inOrOut.equals("in"))
            return iCampaignAttendeeService.updateOne(attendantId, 1);
        if (inOrOut.equals("out"))
            return iCampaignAttendeeService.updateOne(attendantId, 0);
        throw new RequestException(ResultCode.PARAM_REQUIRED);
    }

    @Operation(summary = "订阅推送")
    @PostMapping("/notification/subscription")
    public Boolean subscribeMessage(@RequestBody CampaignSubscription campaignSubscription) {
        return iCampaignSubscriptionService.save(campaignSubscription);
    }

    @Operation(summary = "订阅推送")
    @DeleteMapping("/notification/subscription")
    public Boolean unsubscribeMessage(@RequestBody CampaignSubscription campaignSubscription) {
        QueryWrapper<CampaignSubscription> q = new QueryWrapper<>();
        q.eq("campaign_id", campaignSubscription.getCampaignId());
        q.eq("openid", campaignSubscription.getOpenid());
        return iCampaignSubscriptionService.remove(q);
    }

    @Operation(summary = "发送活动通知")
    @PostMapping("/notification/send")
    Object sendMessage(@RequestBody String campaignId) {

        QueryWrapper q = new QueryWrapper<>();
        q.eq("id", campaignId);
      var info =  iCampaignInfoService.getOne(q);

///上面仅限信息 不是OPENID ！！！

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");


        NotificationData notificationData = new NotificationData(info.getCampaignName(),DateUtil.format(LocalDateTime.now(),"yyyy年MM月dd日 HH:mm"),info.getCampaignLocation(),info.getCampaignTime().format(dt),"如已到场请尽快签到哦" );
        List<String> openids = getSubscribersOpenID(campaignId);
        return notificationUtils.sendNotification("wY3fwfbdveAROT3Z6erKhbP3OT0UPt2VrpihcloigEg", openids, notificationData);

    }


    @Operation(summary = "获取订阅人的OpenID")
    @SuperAccess
    @GetMapping("/notification/get_openid")

    public List<String> getSubscribersOpenID(@RequestParam String campaignId) {
        QueryWrapper<CampaignSubscription> q = new QueryWrapper<>();
        q.select("openid").eq("campaign_id",campaignId);
        return iCampaignSubscriptionService.listObjs(q).stream().map(o->(String) o).collect(Collectors.toList());
    }

}
