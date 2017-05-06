package com.epc.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epc.product.dao.ProductLoaderDAO;
import com.epc.product.domain.UIProduct;
import com.epc.product.model.Product;
import com.epc.product.model.Product1;
import com.epc.product.util.ConvertionUtil;



@Service("userService")
public class ProductServiceImpl implements ProductService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Product> products;
	@Autowired
	@Qualifier("productLoaderDAO")
	ProductLoaderDAO productLoaderDAO;
	
	/*static{
		products= populateDummyUsers();
	}*/

	public List<UIProduct> findAllProducts() {
		//products=populateDummyUsers();
		products=productLoaderDAO.loadProducts();
		return ConvertionUtil.productToUIproduct(products);
	}
	
	
	public UIProduct findById(int id) {
		/*for(Product user : products){
			if(user.getProductId() == id){
				return user;
			}
		}*/
		return ConvertionUtil.productToUIproduct(productLoaderDAO.getProductById(id));
	}
	
	public Product findByName(String name) {
		for(Product user : products){
			if(user.getProductName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	public List<UIProduct> findByIds(int[] ids) {
		return ConvertionUtil.productToUIproduct(productLoaderDAO.getProductsByIds(ids));
	}
	
	
	/*private static List<Product1> populateDummyUsers(){
		List<Product1> products = new ArrayList<Product1>();
		products.add(new Product1(counter.incrementAndGet(),"tomoto_roma", "TOMATO ROMA", new ArrayList<String>(Arrays.asList("400x400")), "VEGETABLESType","$0.20",	"1lb", "VEGETABLESCatogery",1));
		products.add(new Product1(counter.incrementAndGet(),"long_chilli_green", "long chilli green", new ArrayList<String>(Arrays.asList("400x400")), "VEGETABLESType","$0.20",	"1lb", "VEGETABLESCatogery",1));
		products.add(new Product1(counter.incrementAndGet(),"bellpepper", "bell pepper", new ArrayList<String>(Arrays.asList("400x400")), "VEGETABLESType","$0.20",	"1lb", "VEGETABLESCatogery",1));
		products.add(new Product1(counter.incrementAndGet(),"yellow_onions", "yellow onions", new ArrayList<String>(Arrays.asList("400x400")), "VEGETABLESType","$0.20",	"1lb", "VEGETABLESCatogery",1));
		products.add(new Product1(counter.incrementAndGet(),"indian_chilli_pepper_green", "indian chilli pepper green",new ArrayList<String>(Arrays.asList("400x400")), "VEGETABLESType","$0.20",	"1lb", "VEGETABLESCatogery",1));
		
	return products;
	}*/

	@Override
	public boolean saveProducts(List<Product> productList) {
		return productLoaderDAO.saveProduct(productList);
	}
	@Override
	public boolean saveProducts() {
		return false;//productLoaderDAO.saveProduct(populateDummyUsers());
	}

	public List<UIProduct> getProductsByCategoryId(int categoryId) {
		//products=populateDummyUsers();
		products=productLoaderDAO.getProductByCategoryId(categoryId);
		return ConvertionUtil.productToUIproduct(products);
	}


	@Override
	public List<UIProduct> getProductsByName(String productName) {
		products=productLoaderDAO.loadProductsByName(productName);
		return ConvertionUtil.productToUIproduct(products);
	}
}
