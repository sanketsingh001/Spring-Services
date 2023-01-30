package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class MicroServiceOne2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceOne2Application.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
		
	}
	

}
