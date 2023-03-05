package com.schoolconnect.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序

 */
@SpringBootApplication
@ComponentScan("com.schoolconnect")
public class SchoolConnectAdminApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SchoolConnectAdminApplication.class, args);

    }
}
