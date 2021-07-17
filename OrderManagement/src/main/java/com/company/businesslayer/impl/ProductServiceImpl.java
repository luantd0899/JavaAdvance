package com.company.businesslayer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.businesslayer.IProductService;
import com.company.datalayer.ICategoryRepository;
import com.company.datalayer.IEmployeeRepository;
import com.company.datalayer.IProductRepository;
import com.company.entity.CategoryProduct;
import com.company.entity.Employee;
import com.company.entity.Product;
import com.company.form.ProductFormForCreating;
import com.company.form.ProductFormForUpdating;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repository;
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getDepartmentByID(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Product getProductByName(String productName) {
		return repository.findByProductName(productName);
	}

	@Override
	public void addProduct(ProductFormForCreating newProduct) {
		CategoryProduct categoryProduct = categoryRepository.findById(newProduct.getCategoryId()).get();
		Employee employee = employeeRepository.findById(newProduct.getEmployeeId()).get();
		Product  product = new Product(newProduct.getName(), newProduct.getQuantity(), newProduct.getPrice()); 
		product.setCategory(categoryProduct);
		product.setEmployee(employee);
		
		repository.save(product);
		
	}

	@Override
	public void updateProduct(int id, ProductFormForUpdating updateProduct) {
		Product product = repository.findById(id).get();
		product.setProductName(updateProduct.getName());
		product.setPrice(updateProduct.getPrice());
		product.setQuantity(updateProduct.getQuantity());
		
		
		repository.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = repository.findById(id).get();
		repository.delete(product);
	}

	@Override
	public boolean isProductExistsByID(int id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isProductExistsByName(String productName) {
		return repository.existsByProductName(productName);
	}


}
