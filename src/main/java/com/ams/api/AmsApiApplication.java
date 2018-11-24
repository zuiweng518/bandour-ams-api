package com.ams.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsApiApplication.class, args);
	}
}
