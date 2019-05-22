package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/balance/{username}")
	public String getBalance(@PathVariable String username) {
		return accountService.getUserBalance(username);
	}

	@GetMapping("/due-amount/{username}")
	public String getDueAmount(@PathVariable String username) {
		return accountService.getUserDueAmount(username);
	}

	@GetMapping("/due-date/{username}")
	public String getDueDate(@PathVariable String username) {
		return accountService.getUserDueDate(username);
	}
}
