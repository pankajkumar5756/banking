package com.BankingApplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users_account")
public class AccountEntity {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="account_holder_name")
	private String accountholdername;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="createBy")
	private String createBy;
	
	@Column(name="createOn")
	private LocalDateTime createOn;

	public AccountEntity(long id, String accountholdername, double balance, String createBy, LocalDateTime createOn) {
		super();
		this.id = id;
		this.accountholdername = accountholdername;
		this.balance = balance;
		this.createBy = createBy;
		this.createOn = createOn;
	}

	public AccountEntity(){}
	
	
}
