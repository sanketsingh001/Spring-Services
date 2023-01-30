package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class MicroServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceOneApplication.class, args);
	}

	@GetMapping(path="/loanapplication")
	public String getLoans() {
		return "Loan Application will be shown here";
	}
}
