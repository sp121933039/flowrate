package com.sunpeng.flowrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlowrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowrateApplication.class, args);
    }
}
