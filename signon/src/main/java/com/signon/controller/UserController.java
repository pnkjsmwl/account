package com.signon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signon.model.User;
import com.signon.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable long id) {
		User user = userService.getUserById(id);
		user.getRoles().forEach(r -> System.out.println("->"+r.getRole()));
		if(user.getAccount()!=null)
			System.out.println("->"+user.getAccount().getAccountNumber());
		return userService.getUserById(id);
	}
	
	@GetMapping("/username/{username}")
	public User getUserByUserName(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}