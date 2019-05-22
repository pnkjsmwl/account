package com.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.account.entity.Account;

public interface AccountBackendRepo extends JpaRepository<Account, Long> {

	@Query(value = "select * from account a left join user u ON a.user_id = u.id and a.account_number = :accountNumber",  nativeQuery = true)
	Account findCurrentBalanceFromAccountNumber(@Param("accountNumber") String accountNumber);

	@Query(value = "select * from account a left join user u ON a.user_id = u.id and a.account_number = :accountNumber",  nativeQuery = true)
	Account findDueAmountFromAccountNumber(@Param("accountNumber") String accountNumber);

	@Query(value = "select * from account a left join user u ON a.user_id = u.id and a.account_number = :accountNumber",  nativeQuery = true)
	Account findDueDateFromAccountNumber(@Param("accountNumber") String accountNumber);

}
