package com.airbusinventory.products.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airbusinventory.products.exceptions.ProductNotFoundException;
import com.airbusinventory.products.models.Product;
import com.airbusinventory.products.repos.ProductRepository;

@RestController
@RequestMapping("/productInventory")
public class ProductRestServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productRepository.findAllByOrderByIdAsc();
	}
	
	@PutMapping("/product") 
	public void updateProduct(@RequestBody Product product) {
		getProduct(product.getId());
		productRepository.save(product);
	}
	
	@GetMapping("/productsBy/category") 
	public List<Product> getProductsByCategory(@RequestParam String val) {
		return productRepository.findByCategoryOrderByIdAsc(val);
	}
	

}
