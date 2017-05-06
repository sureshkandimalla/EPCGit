package com.epc.product.service;

import java.util.List;

import com.epc.product.domain.UIProduct;
import com.epc.product.model.Product;

public interface ProductService {

	UIProduct findById(int id);

	Product findByName(String name);

	List<UIProduct> findAllProducts();

	List<UIProduct> getProductsByCategoryId(int categoryId);
	List<UIProduct> getProductsByName(String productName);

	boolean saveProducts(List<Product> productList);

	boolean saveProducts();
}
