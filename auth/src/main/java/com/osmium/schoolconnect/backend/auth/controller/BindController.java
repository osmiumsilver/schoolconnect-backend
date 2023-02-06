package com.osmium.schoolconnect.backend.auth.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.misc.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/2/5
 * @Description
 */
@RestController
@RequestMapping("/auth")
public class BindController {

    @PostMapping("/login")
    public Result<JSONObject> bindUser(){
return null;
    }
}
