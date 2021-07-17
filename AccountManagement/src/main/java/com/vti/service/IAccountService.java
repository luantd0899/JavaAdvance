package com.vti.service;

import java.util.List;



import com.vti.entity.Account;


public interface IAccountService {
	
	public List<Account> getAllAccounts();

	public Account getAccountByID(short id);

	public Account getAccountByUsername(String username);

	public void createAccount(Account account);

	public void updateAccount(Account account);

	public void deleteAccount(short id);

	public boolean isAccountExistsByID(short id);

	public boolean isAccountExistsByUsername(String username);
	
	
}
