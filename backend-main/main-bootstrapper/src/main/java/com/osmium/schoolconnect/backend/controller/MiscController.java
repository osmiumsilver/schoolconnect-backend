package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.utils.RedisUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
