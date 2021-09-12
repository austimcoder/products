package com.airbusinventory.products.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbusinventory.products.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	public List<Product> findAllByOrderByIdAsc();

	public List<Product> findByCategoryOrderByIdAsc(String category);
	
}
