package com.epc.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epc.product.model.Category;
import com.epc.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findByProductId(int id);
	public List<Product> findByCategory(Category c);
	public List<Product> findByproductNameIgnoreCaseContaining(String productName);
	public List<Product> findByproductNameIgnoreCaseStartingWith(String productName);
	public List<Product> findByProductIdIn(int[] a);
	public List<Product> findByProductIdIn(List<Integer> a);
	//public List<Product> findByProductId
	
}
