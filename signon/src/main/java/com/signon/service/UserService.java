package com.signon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.signon.model.User;

@Service
public class UserService {

	@Autowired
	private RestTemplate rt;

	String BACKEND_URL = "http://account-backend-service/account-be/user";

	public User getUserById(long id) {
		ResponseEntity<User> respEntity = rt.getForEntity(BACKEND_URL+"/id/{id}", User.class, id);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
		{
			return respEntity.getBody();
		}
		return null;
	}

	public User getUserByUsername(String username) {

		ResponseEntity<User> respEntity = rt.getForEntity(BACKEND_URL+"/username/{username}", User.class, username);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
		{
			return respEntity.getBody();
		}
		return null;
	}

	public User addUser(User user) {

		ResponseEntity<User> respEntity = rt.postForEntity(BACKEND_URL+"/add", user, User.class);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
		{
			return respEntity.getBody();
		}
		return null;
	}
}
