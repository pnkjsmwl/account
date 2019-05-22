package com.account.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class User {

	private long id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
	private Account account;
	
}
