package com.example.demo.controller;

import com.example.demo.dto.CibilScoreDto;
import com.example.demo.dto.LoanApplicationDto;

import lombok.Data;

@Data
public class Combined {

	LoanApplicationDto loanDtoObject;
	CibilScoreDto cibilScoreDtoObject;
	String status;
	
	
}
