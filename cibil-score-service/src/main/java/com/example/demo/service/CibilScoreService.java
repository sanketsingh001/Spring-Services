package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CibilScore;
import com.example.demo.ifaces.CibilScoreRepos;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CibilScoreService {

	private CibilScoreRepos repo;
	
	public CibilScore save(CibilScore entity) {
		return this.repo.save(entity);
	}
	
	public List<CibilScore> findAll(){
		return this.repo.findAll();
	}
	
	public CibilScore findById(String id) {
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Element Not Found"));
	
	}
}
