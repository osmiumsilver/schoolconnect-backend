package com.osmium.schoolconnect.backend.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptScan;

@EntityScan
@EruptScan
@SpringBootApplication
public class BackendAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendAdminApplication.class, args);
    }

}
