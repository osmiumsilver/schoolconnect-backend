package com.osmium.schoolconnect.backend.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.osmium.schoolconnect.backend.main.mapper")
public class SchoolConnectApplication{

	public static void main(String[] args) {
		SpringApplication.run(SchoolConnectApplication.class, args);
	}

}
