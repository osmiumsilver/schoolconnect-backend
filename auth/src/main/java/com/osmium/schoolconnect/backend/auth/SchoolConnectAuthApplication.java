package com.osmium.schoolconnect.backend.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author
 * @Date 2023/2/4
 * @Description
 */
@SpringBootApplication
@MapperScan("com.osmium.schoolconnect.backend.auth.mapper")
@ComponentScan("com.osmium.schoolconnect.backend")

public class SchoolConnectAuthApplication{

    public static void main(String[] args) {
        SpringApplication.run(SchoolConnectAuthApplication.class, args);
    }

}
