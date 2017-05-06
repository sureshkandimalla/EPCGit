package com.epc.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epc.product.domain.CartProduct;
import com.epc.product.domain.UIProduct;
import com.epc.product.service.ProductService;
import com.epc.product.util.CustomErrorType;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*")
@Api(name = "Product Managment API", description = "This service is designed to provide information abut products", stage = ApiStage.BETA)
public class ProductMgmtRestCtrl {

	public static final Logger logger = LoggerFactory.getLogger(ProductMgmtRestCtrl.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@ApiMethod(description = "Get product by product id")
	public ResponseEntity<?> getProduct(@ApiPathParam(name = "id") @PathVariable("id") int id) {
		return getProductById(id);
	}

	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	@ApiMethod(description = "Get product by product id")
	public ResponseEntity<?> getProductQueryParam(@QueryParam("productId") Integer productId) {
		return getProductById(productId);
	}

	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	@ApiMethod(description = "Get all products")
	public ResponseEntity<?> getproducts(@QueryParam("categoryId") Integer categoryId,
			@QueryParam("productId") Integer productId,
			@QueryParam("productName") String productName) {
		List<UIProduct> productList = null;
		if (categoryId != null)
			productList = productService.getProductsByCategoryId(categoryId);
		else if(productName!=null){
			//productName="%"+productName+"%";
			productList = productService.getProductsByName(productName);
		}else if (productId != null) {
			productList = new ArrayList<UIProduct>();
			productList.add(productService.findById(productId));

		} else
			productList = productService.findAllProducts();
		if (productList == null) {
			logger.error("No procuts found");
			return new ResponseEntity<Object>(new CustomErrorType("Products ot found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UIProduct>>(productList, HttpStatus.OK);
	}

	private ResponseEntity<?> getProductById(int id) {
		logger.info("Fetching Product with id {}", id);
		UIProduct user = productService.findById(id);
		if (user == null) {
			logger.error("Product with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Product with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UIProduct>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public boolean saveProducts() {
		return productService.saveProducts();
	}
	
	@Consumes({MediaType.APPLICATION_JSON})
	@RequestMapping(value = "/getCart/", method = RequestMethod.POST)
	public ResponseEntity<?> getProductsForProduct(@RequestBody List<CartProduct> products) {
		System.out.println("Suresh ");
		return null;//getProductById(id);
	}

}