package com.osmium.schoolconnect.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author
 * @Date 2023/2/4
 * @Description
 */
@SpringBootApplication
@MapperScan("com.osmium.schoolconnect.backend.mapper")

public class SchoolConnectAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolConnectAuthApplication.class, args);
    }

}
