package com.schoolconnect.admin.web.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping("/")
    public String index() {
        return "ok";
    }
}
