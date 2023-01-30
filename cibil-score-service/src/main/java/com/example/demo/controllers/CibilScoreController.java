package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.service.CibilScoreService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/v1")
@AllArgsConstructor
public class CibilScoreController {

	private CibilScoreService service;
	@GetMapping(path="/score/{panNumber}")
	public CibilScore findById(@PathVariable("panNumber") String panNumber) {
		return this.service.findById(panNumber);
		
	}
}
