package com.vti.entity.enumerate;

public enum EUserRole {
	ADMIN("Admin"), EMPLOYEE("Employee"), MANAGER("Manager");
	
	private String value;
	
	private EUserRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
