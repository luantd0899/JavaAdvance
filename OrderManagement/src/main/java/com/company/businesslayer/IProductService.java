package com.company.businesslayer;

import java.util.List;

import com.company.entity.Product;
import com.company.form.ProductFormForCreating;
import com.company.form.ProductFormForUpdating;

public interface IProductService {
	public List<Product> getAllProducts();

	public Product getDepartmentByID(int id);

	public Product getProductByName(String productName);

	public void addProduct(ProductFormForCreating newProduct);

	public void updateProduct(int id, ProductFormForUpdating updateProduct);

	public void deleteProduct(int id);

	public boolean isProductExistsByID(int id);

	public boolean isProductExistsByName(String productName);
	
}
