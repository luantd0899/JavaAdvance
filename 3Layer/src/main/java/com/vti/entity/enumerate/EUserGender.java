package com.vti.entity.enumerate;

public enum EUserGender {
	M("M"), F("F"), U("U");
	
	private String value;
	
	private EUserGender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
