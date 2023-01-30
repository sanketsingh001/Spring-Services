package com.example.demo.controllers;

import org.aspectj.weaver.tools.Trace;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.service.CibilScoreService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path="/api/v1")
@AllArgsConstructor
@Log4j2
public class CibilScoreController {
	
	
	private Tracer tracer;
  private CibilScoreService service;
	@GetMapping(path="/score/{panNumber}")
	public CibilScore findById(@PathVariable("panNumber") String panNumber) {
		log.info("I am In  Controller");
		
		return this.service.findById(panNumber);
		
	}
}
