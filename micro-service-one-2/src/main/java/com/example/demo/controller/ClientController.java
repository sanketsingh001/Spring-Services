package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CibilScoreDto;
import com.example.demo.dto.LoanApplicationDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {
	
private RestTemplate template;
private RestTemplate template2; 

@GetMapping(path="/client/loanApplications")
public LoanApplicationDto[] getAllLoanApplication() {
	return template.getForObject("http://SERVICE-ONE/api/v1/loanapplication", LoanApplicationDto[].class);
}

@GetMapping(path="/client/loanApplications/{id}")
public LoanApplicationDto getById(@PathVariable("id") int id) {
	String url="http://SERVICE-ONE/api/v1/loanapplication/"+id;
	return template.getForObject(url, LoanApplicationDto.class);
}

@GetMapping(path="/client/cibilscore/{pan}")
public Combined getcibil(@PathVariable("pan") String pan) {
	String url="http://SERVICE-THREE/api/v1/score/"+pan;
	CibilScoreDto dtoObj= template.getForObject(url, CibilScoreDto.class);
	String url2="http://SERVICE-ONE/api/v1/loanapplication/search/"+pan;
	LoanApplicationDto dto2=template2.getForObject(url2, LoanApplicationDto.class);

	Combined obj = new Combined();
	obj.setCibilScoreDtoObject(dtoObj);
	obj.setLoanDtoObject(dto2);
	
	
	if(dtoObj.getScore()>500) {
		obj.setStatus("approved");
	}else {
		obj.setStatus("declined");
	}
	return obj;
}


}
