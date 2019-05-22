package com.account.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name ="account")
@Data
public class Account {
	Account(){}
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String accountNumber;
	private String currentBalance;
	private String dueAmount;
	private String dueDate;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (!(o instanceof Account )) 
			return false;
		return id >0 && id==((Account) o).getId();
	}
	@Override
	public int hashCode() {
		return 31;
	}
}
