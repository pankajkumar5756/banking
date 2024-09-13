package com.BankingApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.entity.AccountEntity;
import com.BankingApplication.mapper.AccountMapper;
import com.BankingApplication.repo.AccountRepo;
import com.BankingApplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		AccountEntity accountEntity = AccountMapper.mapToAccount(accountDto);
		
		AccountEntity saveAccount = accountRepo.save(accountEntity);
				
		return AccountMapper.mapAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		
		AccountEntity accountEntity = accountRepo.findById(id).orElseThrow((()-> new RuntimeException("Account does not exist")));
		
		return AccountMapper.mapAccountDto(accountEntity);
	}

	@Override
	public AccountDto deposite(Long id, double amount) {
		
		AccountEntity accountEntity = accountRepo.findById(id).orElseThrow((()-> new RuntimeException("Account does not exist")));
		
		double totalBalance = accountEntity.getBalance()+amount;
		accountEntity.setBalance(totalBalance);
		AccountEntity saveAccount = accountRepo.save(accountEntity);
		
		return AccountMapper.mapAccountDto(saveAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {

		AccountEntity accountEntity = accountRepo.findById(id).orElseThrow((()-> new RuntimeException("Account does not exist")));
		
		if(accountEntity.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		
		double totalBalance = accountEntity.getBalance()-amount;
		accountEntity.setBalance(totalBalance);
		AccountEntity saveAccount = accountRepo.save(accountEntity);

		return AccountMapper.mapAccountDto(saveAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
				
		List<AccountDto> accountDto = accountRepo.findAll().stream().map((account) -> AccountMapper.mapAccountDto(account)).collect(Collectors.toList());
		
		return accountDto;
	}

	@Override
	public void deleteAccount(Long id) {
		
		AccountEntity accountEntity = accountRepo.findById(id).orElseThrow((()-> new RuntimeException("Account does not exist")));
		
		accountRepo.delete(accountEntity);
		
	}

}
