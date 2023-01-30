package com.example.demo.dto;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanApplicationDto {

		int applicationNumber;
	    String customerName;
		double loanAmount;
		String panNumber;

}
