package com.company.presentationlayer;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.businesslayer.IProductService;
import com.company.dto.CategoryProductDTO;
import com.company.dto.EmployeeDTO;
import com.company.dto.ProductDTO;
import com.company.entity.Product;
import com.company.form.ProductFormForCreating;
import com.company.form.ProductFormForUpdating;

@RestController
@RequestMapping(value = "api/v1/products")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	
	@GetMapping
	public ResponseEntity<?> getAllProduct(){
		List<Product> products = productService.getAllProducts();
		
		List<ProductDTO> dtos = new ArrayList<>();
		
		// Convert entity to DTO
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO(	
													product.getProductId(),
													new CategoryProductDTO(product.getCategory().getCategoryName()),
													product.getProductName(),
													product.getQuantity(),
													product.getPrice(),
													product.getImportDate(),
													new EmployeeDTO(product.getEmployee().getName())
													);
			dtos.add(productDTO);
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name = "id") int id){
		Product product = productService.getDepartmentByID(id);
		ProductDTO dto = new ProductDTO(
										product.getProductId(),
										new CategoryProductDTO(product.getCategory().getCategoryName()),
										product.getProductName(),
										product.getQuantity(),
										product.getPrice(),
										product.getImportDate(),
										new EmployeeDTO(product.getEmployee().getName())
										);
		return new ResponseEntity<ProductDTO>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addProduct (@RequestBody ProductFormForCreating newProduct){
		productService.addProduct(newProduct);
		return new ResponseEntity<String>("Create Successfully!", HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateProduct (@PathVariable(name = "id") int id, 
											@RequestBody ProductFormForUpdating newProduct)
	{
		productService.updateProduct(id, newProduct);
		return new ResponseEntity<String>("Update Successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Delete Successfully!", HttpStatus.OK);
	}
	
	
	
}
