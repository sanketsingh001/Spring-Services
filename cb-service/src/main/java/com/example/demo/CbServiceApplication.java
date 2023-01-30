package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@RestController
@Log4j2
public class CbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbServiceApplication.class, args);
	}

	
	
	@GetMapping(path = "/api/v1/employees/{id}")
    public String grtEmployeeById(@PathVariable("id") int id) throws InterruptedException {
	 log.info("Get Employee by id called woth Number"+id);
		return id>10?"Sanket":"singh";
    }

}
