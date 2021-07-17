package com.company.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	public Product findByProductName(String productName);
	
	public boolean existsByProductName(String productName);
}
