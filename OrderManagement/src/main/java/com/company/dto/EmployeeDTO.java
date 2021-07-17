package com.company.dto;

public class EmployeeDTO {
	private int id;
	private String fullName;

	public String getFullName() {
		return fullName;
	}
	public EmployeeDTO(String fullName) {

		this.fullName = fullName;
	}
	
	
}
