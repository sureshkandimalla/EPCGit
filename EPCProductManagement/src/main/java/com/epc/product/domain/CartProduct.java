package com.epc.product.domain;

public class CartProduct {
	private Integer productId;
	private UIProduct uiProduct;
	private Integer quntity;
	private Double totalPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public UIProduct getUiProduct() {
		return uiProduct;
	}
	public void setUiProduct(UIProduct uiProduct) {
		this.uiProduct = uiProduct;
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
