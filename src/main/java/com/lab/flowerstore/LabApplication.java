package com.lab.flowerstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // API level, route endpoints to methods
public class LabApplication {
    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
}
}