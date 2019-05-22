package com.account.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="role")
@Data
public class Role {

	Role(){}
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String role;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (!(o instanceof Role )) 
			return false;
		return id >0 && id==((Role) o).getId();
	}
	@Override
	public int hashCode() {
		return 31;
	}
}
