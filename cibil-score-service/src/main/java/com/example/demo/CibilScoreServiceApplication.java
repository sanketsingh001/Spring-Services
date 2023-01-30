package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CibilScoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CibilScoreServiceApplication.class, args);
	}
	@GetMapping(path="/CibilScore")
	public String getScore() {
		return "Cibil Score will be shown here";
	}
}
