package com.vti.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class DepartmentDto {
	private short id;

	private String name;

	private AccountDto author;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;

	public DepartmentDto(short id, String name, AccountDto author, Date createDate) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.createDate = createDate;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public AccountDto getAuthor() {
		return author;
	}

	public void setAuthor(AccountDto author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
//	public Department toEntity() {
//		Account account = new Account();
//		Department department = new Department();
//		department.setId(id);
//		department.setName(name);
//		department.setAuthor(account);
//		department.setCreateDate(createDate);
//		return department;
//	}

}
