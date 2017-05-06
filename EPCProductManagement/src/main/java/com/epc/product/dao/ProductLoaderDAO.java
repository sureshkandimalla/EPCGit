package com.epc.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epc.product.config.PropertyUtils;
import com.epc.product.model.Category;
import com.epc.product.model.Product;
import com.epc.product.model.Product;

@Repository
public class ProductLoaderDAO {
	@Autowired
	@Qualifier("jdbcTemplete")
	public JdbcTemplate jdbcTemplate;
	@Autowired
	ProductDataExtractor extractor;
	@Autowired
	ProductRepository repo;

	public List<Product> loadProducts() {
		List<Product> records = repo.findAll();
		return records;
	}
	public List<Product> loadProductsByName(String productName) {
		List<Product> records = repo.findByproductNameIgnoreCaseContaining(productName);
		//List<Product> records = repo.findByproductNameIgnoreCaseStartingWith(productName);
		return records;
	}

	public Product getProductById(int id) {
		Product record = new Product();
		record.setProductId(1);
		record = repo.findByProductId(id);
		return record;
	}

	public boolean saveProduct(List<Product> productList) {
		jdbcTemplate.batchUpdate(PropertyUtils.getProductsInsertQuery(), new ProductSetter(productList));
		return true;
	}

	public void getProduct() {
		Iterable<Product> a = repo.findAll();
		System.out.println(a);

	}

	public List<Product> getProductByCategoryId(int categoryId) {
		Category c=new Category();
		c.setCategoryId(categoryId);
		List<Product> a = repo.findByCategory(c);
		return a;

	}
	public List<Product> getProductsByIds(int[] productIds) {
		
		List<Product> a = repo.findByProductIdIn(productIds);
		 System.out.println("##############################");
		 System.out.println(a.size());
		return a;

	}
	
public List<Product> getProductsByIds(List<Integer> productIds) {
		
		List<Product> a = repo.findByProductIdIn(productIds);
		 System.out.println("##############################");
		 System.out.println(a.size());
		return a;

	}
	public Product getProductDetails(Product p)
	{
		// p=repo.findByProductId(p.getProductId());
		 int[]a={1,2};
		 List<Product> k=repo.findByProductIdIn(a);
		 System.out.println("##############################");
		 System.out.println(k.size());
		return p;
	}

}
