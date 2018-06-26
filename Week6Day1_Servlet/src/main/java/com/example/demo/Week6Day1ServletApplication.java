package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Week6Day1ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week6Day1ServletApplication.class, args);
	}
}
