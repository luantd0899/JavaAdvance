package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.dto.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@GetMapping()
	public ResponseEntity<?> getAllAccounts(){
		List<Account> accounts = accountService.getAllAccounts();
		
		List<AccountDTO> dtos = new ArrayList<>();
		
		for (Account account : accounts) {
			
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setEmail(account.getEmail());
			accountDTO.setUsername(account.getUsername());
			accountDTO.setDepartment(new DepartmentDTO());
			accountDTO.setCreateDate(account.getCreateDate());
			dtos.add(accountDTO);
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
		
	}
}
