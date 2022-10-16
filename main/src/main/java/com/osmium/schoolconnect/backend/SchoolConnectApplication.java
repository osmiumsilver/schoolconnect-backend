package com.osmium.schoolconnect.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.osmium.schoolconnect.backend.mapper")
public class SchoolConnectApplication{

	public static void main(String[] args) {
		SpringApplication.run(SchoolConnectApplication.class, args);
	}

}
