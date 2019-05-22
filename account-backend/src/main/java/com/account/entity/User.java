package com.account.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	
	User(){}
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Role> roles = new HashSet<Role>();

	@OneToOne(mappedBy="user",cascade=CascadeType.ALL, orphanRemoval=true)
	private Account account;
	
	
	public User(User user) {
		this.fname = user.getFname();
		this.lname = user.getLname();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
		role.setUser(this);
	}
	public void removeRole(Role role) {
		roles.remove(role);
		role.setUser(null);
	}
	
	public void addAccount(Account account) {
		this.setAccount(account);
		account.setUser(this);
	}
	public void removeAccount(Account account) {
		this.setAccount(null);
		account.setUser(null);
	}
}
