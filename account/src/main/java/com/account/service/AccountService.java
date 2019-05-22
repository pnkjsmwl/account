package com.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.account.model.User;

@Service
public class AccountService {


	String BACKEND_URL = "http://account-backend-service/account-be/user";

	//@Value("${USER-BALANCE-URL}")
	String userBalanceUrl;

	//@Value("${USER-DUE-AMOUNT-URL}")
	String userDueAmountUrl;

	//@Value("${USER-DUE-DATE-URL}")
	String userDueDateUrl;


	@Autowired
	private RestTemplate rt;

	public String getUserBalance(String username) {

		ResponseEntity<User> respEntity = rt.getForEntity(BACKEND_URL+"/balance/{username}", User.class, username);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
		{
			return respEntity.getBody().getAccount().getCurrentBalance();
		}
		return null;
	}

	public String getUserDueAmount(String username) {
		ResponseEntity<User> respEntity = rt.getForEntity(BACKEND_URL+"/due-amount/{username}", User.class, username);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
		{
			return respEntity.getBody().getAccount().getDueAmount();
		}
		return null;
	}

	public String getUserDueDate(String username) {
		ResponseEntity<User> respEntity = rt.getForEntity(BACKEND_URL+"/due-date/{username}", User.class, username);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
		{
			return respEntity.getBody().getAccount().getDueDate();
		}
		return null;
	}

}
