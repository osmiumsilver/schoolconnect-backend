package com.osmium.schoolconnect.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.osmium.schoolconnect.backend.mapper")
@ComponentScan("com.osmium.schoolconnect")
public class SchoolConnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolConnectApplication.class, args);
    }

}
