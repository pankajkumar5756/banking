package com.BankingApplication.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountDto {
	
	
	private long id;
	private String accountholdername;
	private double balance;
	private String createBy;
	private LocalDateTime createOn;
			
	public AccountDto(long id, String accountholdername, double balance, String createBy, LocalDateTime createOn) {
		super();
		this.id = id;
		this.accountholdername = accountholdername;
		this.balance = balance;
		this.createBy = createBy;
		this.createOn = createOn;
	}
	
	 public AccountDto(){}

}
