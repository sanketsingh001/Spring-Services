package com.example.demo.controlller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {
	


	private WebClient client;

	private ReactiveResilience4JCircuitBreakerFactory cbFactory;
	private ReactiveCircuitBreaker cb;
	
	
	
	
	public ClientController(WebClient client, ReactiveResilience4JCircuitBreakerFactory cbFactory) {
		super();
		this.client = client;
		this.cbFactory = cbFactory;
		
		this.cb= this.cbFactory.create("employee-cb");
	}




	@GetMapping(path="/client/employees/{id}")
	public Mono<String> getEmployees(@PathVariable("id") int id){
		return this.cb.run(client.get().uri("http://localhost:1515/api/v1/employees/"+id)
				.retrieve()
				.bodyToMono(String.class).timeout(Duration.ofMillis(10000))
				,throwable ->Mono.just("Default Employee")
				);
		
		
		
//		return client.get().uri("http://localhost:1515/api/v1/employees/"+id).retrieve()
//				.bodyToMono(String.class).timeout(Duration.ofMillis(100));
		
		
		
	}
	
}
