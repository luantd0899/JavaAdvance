package com.company.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DepartmentDTO {
	
	private short id;
	private String name;
	private AccountDTO author;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;
	
	public DepartmentDTO(short id, String name, AccountDTO author, Date createDate) {
		super();
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

	public AccountDTO getAuthor() {
		return author;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	
	
	
	
	
}
