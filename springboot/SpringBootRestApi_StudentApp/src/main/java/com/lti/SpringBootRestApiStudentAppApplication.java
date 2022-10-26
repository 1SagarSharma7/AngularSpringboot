package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiStudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiStudentAppApplication.class, args);
		System.out.println("Student App started !!!");
	}

}
