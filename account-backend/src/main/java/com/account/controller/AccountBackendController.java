package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.User;
import com.account.service.UserService;

@RestController
@RequestMapping("/account-be/user")
public class AccountBackendController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/id/{id}")
	public User getUser(@PathVariable long id) {
		return userService.getUser(id);
	}
	@GetMapping("/username/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@GetMapping("/balance/{username}")
	public String getBalance(@PathVariable String username) {
		return userService.getBalance(username);
	}
	
	@GetMapping("/due-amount/{username}")
	public String getDueAmount(@PathVariable String username) {
		return userService.getDueAmount(username);
	}
	
	@GetMapping("/due-date/{username}")
	public String getDueDate(@PathVariable String username) {
		return userService.getDueDate(username);
	}
	
	@PostMapping("/add")
	public User getDueDate(@RequestBody User user) {
		return userService.addUser(user);
	}
}
