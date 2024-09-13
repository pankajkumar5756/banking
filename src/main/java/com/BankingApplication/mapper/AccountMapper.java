package com.BankingApplication.mapper;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.entity.AccountEntity;

public class AccountMapper {
	
	public static AccountEntity mapToAccount(AccountDto accountDto) {
		
		AccountEntity account = new AccountEntity(
				
				accountDto.getId(),
				accountDto.getAccountholdername(),
				accountDto.getBalance(),
				accountDto.getCreateBy(),
				accountDto.getCreateOn()
				
				
				);
		return account;
	}
	
	public static AccountDto mapAccountDto(AccountEntity accountEntity) {
		
		AccountDto accountDto = new AccountDto(
				
				accountEntity.getId(),
				accountEntity.getAccountholdername(),
				accountEntity.getBalance(),
				accountEntity.getCreateBy(),
				accountEntity.getCreateOn()
				
				);
		return accountDto;
	}

}
