package com.lab7.lab72;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // API level, route endpoints to methods
public class Lab72Application {
	public static void main(String[] args) {
		SpringApplication.run(Lab72Application.class, args);
	}
}