package com.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.entity.User;
import com.account.repo.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;
	private AccountBackendService accountBackendService;

	@Autowired
	public UserService(UserRepo userRepo, AccountBackendService accountBackendService) {
		this.userRepo = userRepo;
		this.accountBackendService = accountBackendService;
	}

	public User getUser(long id) {
		Optional<User> findById = userRepo.findById(id);
		if(findById.isPresent())
			return findById.get();
		return null;
	}


	public User getUser(String username) {
		return userRepo.findUserByUsername(username);
	}
	
	public User addUser(User user) {
		
		User userForDB = new User(user);
		user.getRoles().forEach(role -> userForDB.addRole(role));
		userForDB.addAccount(user.getAccount());
		return userRepo.save(userForDB);
	}
	
	public String getBalance(String username) {
		String balance = null;
		User user = userRepo.findUserByUsername(username);
		if(user!=null && user.getAccount()!=null) {
			balance = accountBackendService.getBalance(user.getAccount().getAccountNumber());
		}
		return balance;
	}

	public String getDueAmount(String username) {
		String dueAmount = null;
		User user = userRepo.findUserByUsername(username);
		if(user!=null && user.getAccount()!=null) {
			dueAmount = accountBackendService.getDueAmount(user.getAccount().getAccountNumber());

		}
		return dueAmount;
	}

	public String getDueDate(String username) {
		String dueDate = null;
		User user = userRepo.findUserByUsername(username);
		if(user!=null && user.getAccount()!=null) {
			dueDate = accountBackendService.getDueDate(user.getAccount().getAccountNumber());
		}
		return dueDate;
	}

}
