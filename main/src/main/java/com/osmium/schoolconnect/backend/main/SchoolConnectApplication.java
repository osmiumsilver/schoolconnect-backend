package com.osmium.schoolconnect.backend.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.osmium.schoolconnect.backend.main.mapper")
@ComponentScan("com.osmium.schoolconnect.backend")
public class SchoolConnectApplication{

	public static void main(String[] args) {
		SpringApplication.run(SchoolConnectApplication.class, args);
	}

}
