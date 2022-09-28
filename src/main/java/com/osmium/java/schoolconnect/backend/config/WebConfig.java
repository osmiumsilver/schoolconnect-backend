package com.osmium.java.schoolconnect.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author
 * @Date 2022/9/27
 * @Description
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.osmium.java.schoolconnect.backend.controller")
public class WebConfig {

}
