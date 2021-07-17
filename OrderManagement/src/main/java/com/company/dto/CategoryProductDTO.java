package com.company.dto;


public class CategoryProductDTO {
	private int id;
	private String categoryName;
	
	public String getCategoryName() {
		return categoryName;
	}
	public CategoryProductDTO(String categoryName) {

		this.categoryName = categoryName;
	}
	
	
}
