package com.company.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;




@Entity
@Table(name = "product")
public class Product {
	
	@Column(name = "productID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = true, updatable = true)
	private CategoryProduct category;
	
	@Column(name = "productName", length = 100, nullable = false)
	private String productName;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "importDate")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date importDate;
	
	@ManyToOne
	@JoinColumn(name = "employeeID", nullable = false, updatable = false)
	private Employee employee;

	public Product() {
		
	}
	
	public Product(String productName, int quantity, int price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

	
	
	
}
