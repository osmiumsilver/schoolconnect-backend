package com.osmium.java.schoolconnect.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.osmium.java.schoolconnect.backend.mapper")
public class SchoolConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolConnectApplication.class, args);
	}

}
