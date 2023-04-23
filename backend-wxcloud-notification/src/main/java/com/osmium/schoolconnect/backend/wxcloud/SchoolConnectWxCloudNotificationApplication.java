package com.osmium.schoolconnect.backend.wxcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author
 * @Date 2023/4/16
 * @Description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SchoolConnectWxCloudNotificationApplication {
    public static void main(String[] args) {
    SpringApplication.run(SchoolConnectWxCloudNotificationApplication.class, args);
}
}
