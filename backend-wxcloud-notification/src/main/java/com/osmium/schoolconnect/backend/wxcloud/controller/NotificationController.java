package com.osmium.schoolconnect.backend.wxcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author
 * @Date 2023/4/16
 * @Description
 */
@RestController
@Slf4j
@RequestMapping("/api/notification")
public class NotificationController {

    @PostMapping
    public Object Test(@RequestBody Object object) {
        log.info(object.toString());
        return object.toString();
    }

}
