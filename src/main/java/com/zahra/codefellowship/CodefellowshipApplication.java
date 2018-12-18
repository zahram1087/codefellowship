package com.zahra.codefellowship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodefellowshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodefellowshipApplication.class, args);

		System.out.println("http://localhost:8080/");
		System.out.println("http://localhost:8080/signup");
		System.out.println("http://localhost:8080/signup/1");

	}

}

