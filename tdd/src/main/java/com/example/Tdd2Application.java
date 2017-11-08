package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.z","com.example.tdd2"})
public class Tdd2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tdd2Application.class, args);
	}
}
