package com.epc.product.domain;

import java.util.List;

public class Cart {
	private Integer cartId;
	private Integer userId;
	private List <UIProduct> uiProducts;
	private Integer zipCode;
	private Double totalPrice;
	private Double tax;
	private Double discount;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List <UIProduct> getUiProducts() {
		return uiProducts;
	}
	public void setUiProducts(List <UIProduct> uiProducts) {
		this.uiProducts = uiProducts;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
