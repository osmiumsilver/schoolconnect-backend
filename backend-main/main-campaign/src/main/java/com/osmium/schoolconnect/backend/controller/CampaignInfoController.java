package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.entity.CampaignInfoPics;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignInfoVO;
import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.CampaignInfoPicsImpl;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import com.osmium.schoolconnect.backend.utils.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@RestController
@RequestMapping("/campaign")
@Tag(name = "活动信息")
public class CampaignInfoController {
    private final ICampaignInfoService iCampaignInfoService;
private final CampaignInfoPicsImpl campaignInfoPicsImpl;

    public CampaignInfoController(ICampaignInfoService iCampaignInfoService, CampaignInfoPicsImpl campaignInfoPicsImpl) {
        this.iCampaignInfoService = iCampaignInfoService;
        this.campaignInfoPicsImpl = campaignInfoPicsImpl;
    }


    @Operation(summary = "查询我发起的活动")
    @GetMapping("/my")
    public List<CampaignInfoVO> fetchCampaignsILaunched(Authentication authentication) {
        return iCampaignInfoService.listCampaignsByLauncher(authentication.getName());
    }
    @Operation(summary = "查询我参加的活动")
    @GetMapping("/isigned")
    public List<CampaignInfo> fetchCampaignsISignedUpFor(Authentication authentication,@RequestParam String status) {
        return iCampaignInfoService.listCampaignsUserSignedUpFor(authentication.getName(),status);
    }

    @Operation(summary = "根据状态查询活动（正在报名，已开始，已结束")
    @GetMapping
    public List<CampaignInfo> getCampaignsByStatus(@RequestParam (required = false) String status) {
        return iCampaignInfoService.getCampaignByStatus(status);
    }
    @Operation(summary = "根据Id路径查询活动信息")
    @GetMapping("/{id}")
    public CampaignInfoVO getCampaignById(@PathVariable String id) {
        return iCampaignInfoService.getById(id);
    }
    @Operation(summary = "用户添加活动")
    @PostMapping
    public Boolean addMyCampaign(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.save(newCampaigns);
    }

    @Operation(summary = "添加图片")
    @PostMapping("/addpic")

    public Boolean addPics(@RequestBody CampaignInfoPics newCampaigns) {

        return campaignInfoPicsImpl.save(newCampaigns);
    }


    @Operation(summary = "获取图片")
   @GetMapping("/getpic")
    public List<String> getPictures(@RequestParam String campaignId){
       return  iCampaignInfoService.listPictures(campaignId);
    }

    @Operation(summary = "用户修改活动")
    @PutMapping
    public Boolean modifyMyCampaign(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.updateById(newCampaigns);
    }
    @Operation(summary = "设置活动状态")
    @PatchMapping
    public Boolean setCampaignStatus(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.updateById(newCampaigns);
    }
    @Operation(summary = "用户删除活动")
    @DeleteMapping
    public Boolean deleteMyCampaign(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.removeById(newCampaigns);
    }

}



