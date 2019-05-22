package com.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findUserByUsername(String username);

}
