package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.utils.RedisUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/21
 * @Description
 */
@RestController
@RequestMapping("/campaign")
@Tag(name = "活动信息界面")

public class CampaignUIController {

    private final RedisUtils redisUtils;

    public CampaignUIController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Operation(summary = "获取活动专区封面图片URL")

    @GetMapping("/banner")
    public List<String> getBannerUrl() {
        return redisUtils.getCacheList("campaign_url");
    }
}
