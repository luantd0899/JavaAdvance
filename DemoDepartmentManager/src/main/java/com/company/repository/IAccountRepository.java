package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.company.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short> {
	
	public Account findByUsername(String username);
}
