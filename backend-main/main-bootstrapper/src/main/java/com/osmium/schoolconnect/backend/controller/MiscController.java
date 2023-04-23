package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.utils.RedisUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/9
 * @Description
 */
@RestController
public class MiscController {
    private RedisUtils redisUtils;

    public MiscController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Operation(summary = "获取开学时间")
    @GetMapping("/startdate")
    public List<Object> getStartDate(){
        return redisUtils.getCacheList("semester_start_date");
    }
}
