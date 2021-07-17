package com.company.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductDTO {
	private int id;
	private CategoryProductDTO categoryProduct;
	private String productName;
	private int quantity;
	private int price;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date importDate;
	private EmployeeDTO employee;
	public int getId() {
		return id;
	}
	public CategoryProductDTO getCategoryProduct() {
		return categoryProduct;
	}
	public String getProductName() {
		return productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	}
	public Date getImportDate() {
		return importDate;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public ProductDTO(int id, CategoryProductDTO categoryProduct, String productName, int quantity, int price,
			Date importDate, EmployeeDTO employee) {
		this.id = id;
		this.categoryProduct = categoryProduct;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.importDate = importDate;
		this.employee = employee;
	}
	
	
	
	
}
