package com.osmium.schoolconnect.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/3/2
 * @Description
 */
@RestController
@RequestMapping("/ui")
public class MiscController {

    @GetMapping("/carousel")
    public String getCarousel() {
        return "ok";
    }
}
