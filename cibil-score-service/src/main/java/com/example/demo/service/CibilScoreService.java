package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.Tracer.SpanInScope;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CibilScore;
import com.example.demo.ifaces.CibilScoreRepos;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class CibilScoreService {
	
	
	private Tracer tracer;

	private CibilScoreRepos repo;
	
	public CibilScore save(CibilScore entity) {
		return this.repo.save(entity);
	}
	
	public List<CibilScore> findAll(){
		return this.repo.findAll();
	}
	
	public CibilScore findById(String id)  {
		Span newSpan =tracer.nextSpan().name("second span").start();
	try(SpanInScope ws=tracer.withSpan(newSpan.start())){
		Thread.sleep(1000L);
		log.info("I am in the new span doing some cool work that needs it own space");
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Element Not Found"));

	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		newSpan.end();
	}
	return null;	
		
	
	}
}
