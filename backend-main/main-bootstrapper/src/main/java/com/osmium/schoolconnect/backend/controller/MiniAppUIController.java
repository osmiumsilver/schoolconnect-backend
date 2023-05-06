package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.utils.RedisUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Date 2023/3/2
 * @Description
 */
@RestController
@RequestMapping("/ui")
public class MiniAppUIController {
    private final RedisUtils redisUtils;

    public MiniAppUIController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Operation(summary = "获取轮播图片URL")
    @GetMapping("/carousel")
    public List<Object> getCarousel() {
        return new ArrayList<>(redisUtils.getCacheSet("carousel_urls"));
    }
}
