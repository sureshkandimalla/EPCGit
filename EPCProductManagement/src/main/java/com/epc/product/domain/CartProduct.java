package com.epc.product.domain;

public class CartProduct {
	private Integer productId;
	private UIProduct product;
	private Integer quntity;
	private Double totalPrice;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public UIProduct getProduct() {
		return product;
	}
	public void setProduct(UIProduct product) {
		this.product = product;
	}
	public Integer getQuntity() {
		return quntity;
	}
	public void setQuntity(Integer quntity) {
		this.quntity = quntity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}
