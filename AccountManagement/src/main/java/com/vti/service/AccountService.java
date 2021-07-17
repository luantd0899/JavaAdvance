package com.vti.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountByID(short id) {
		
		return accountRepository.findById(id).get();
	}

	@Override
	public Account getAccountByUsername(String username) {
		
		return accountRepository.findByName(username);
	}

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
	
	}

	@Override
	public void updateAccount(Account account) {
		accountRepository.save(account);
		
	}

	@Override
	public void deleteAccount(short id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public boolean isAccountExistsByID(short id) {
		
		return accountRepository.existsById(id);
	}

	@Override
	public boolean isAccountExistsByUsername(String username) {
		
		return accountRepository.isAccountExist(username);
	}

}
