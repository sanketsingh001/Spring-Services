package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Value("${custom.message}")
	private String message;
	
	@GetMapping(path="/greet")
	public String getMessage() {
		return this.message;
	}
	

	
}
