package com.signon.model;

import lombok.Data;

@Data
public class Account {

	private long id;
	private String accountNumber;
	private String currentBalance;
	private String dueAmount;
	private String dueDate;
}
