package com.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.entity.Account;
import com.account.repo.AccountBackendRepo;

@Service
public class AccountBackendService  {


	@Autowired
	private AccountBackendRepo accountRepo;

	public String getBalance(String accountNumber) {
		Account findCurrentBalanceFromAccountNumber = accountRepo.findCurrentBalanceFromAccountNumber(accountNumber);
		return findCurrentBalanceFromAccountNumber.getCurrentBalance();
	}

	public String getDueAmount(String accountNumber) {
		Account findDueAmountFromAccountNumber = accountRepo.findDueAmountFromAccountNumber(accountNumber);
		return findDueAmountFromAccountNumber.getDueAmount();
	}

	public String getDueDate(String accountNumber) {
		Account findDueDateFromAccountNumber = accountRepo.findDueDateFromAccountNumber(accountNumber);
		return findDueDateFromAccountNumber.getDueDate();
	}

}
