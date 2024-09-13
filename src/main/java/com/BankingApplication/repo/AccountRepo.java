package com.BankingApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankingApplication.entity.AccountEntity;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Long> {

}
