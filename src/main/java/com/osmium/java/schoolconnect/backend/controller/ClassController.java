package com.osmium.java.schoolconnect.backend.controller;

import com.osmium.java.schoolconnect.backend.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author
 * @date 2022/3/30
 * @apinote
 */
@Controller
@RequestMapping("api/class")
public class ClassController {
    private ClassService classService;

    @RequestMapping(value = "addClass", method = RequestMethod.POST)
    public Action addClass(@RequestParam("className") String className,
        return null;

}
