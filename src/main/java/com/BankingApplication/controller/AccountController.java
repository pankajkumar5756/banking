package com.BankingApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	
	@PostMapping("/add/account")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		
		System.out.print(accountDto);
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
		
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposite(id, amount);
		
		return ResponseEntity.ok(accountDto);	
	}	
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
		
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDto);
		
	}
	
	@GetMapping("/all/accounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountDto = accountService.getAllAccounts();
		
		return ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("Account Deleted Successfully !");
	}
	
}
