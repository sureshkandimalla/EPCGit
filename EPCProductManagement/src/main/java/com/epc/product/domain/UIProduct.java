package com.epc.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.epc.product.config.PropertyUtils;

/**
 * The persistent class for the products database table.
 * 
 */
public class UIProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productId;

	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setImageURLs(List<String> imageURLs) {
		this.imageURLs = imageURLs;
	}

	private int productCategoryId;

	private String productDscription;

	private String productImages;

	private String productName;

	private BigDecimal productPrice;

	private BigDecimal productPriceCompareat;

	private String productSku;

	private int productSubCategoryId;
	private String productCategory;
	private String produSubctCategory;

	private String productTitle;

	private String productType;

	private BigDecimal productWeight;
	
	private int quantity;

	// Additinal properties for UI

	private List<String> imageURLs;

	public UIProduct() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductDscription() {
		return this.productDscription;
	}

	public void setProductDscription(String productDscription) {
		this.productDscription = productDscription;
	}

	public String getProductImages() {
		return this.productImages;
	}

	public void setProductImages(String productImages) {
		this.productImages = productImages;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getProductPriceCompareat() {
		return this.productPriceCompareat;
	}

	public void setProductPriceCompareat(BigDecimal productPriceCompareat) {
		this.productPriceCompareat = productPriceCompareat;
	}

	public String getProductSku() {
		return this.productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	public int getProductSubCategoryId() {
		return this.productSubCategoryId;
	}

	public void setProductSubCategoryId(int productSubCategoryId) {
		this.productSubCategoryId = productSubCategoryId;
	}

	public String getProductTitle() {
		return this.productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getProductWeight() {
		return this.productWeight;
	}

	public void setProductWeight(BigDecimal productWeight) {
		this.productWeight = productWeight;
	}

	private void setURL() {
		List<String> imageURL = null;
		if (this.productImages != null && this.productImages.length() > 0)
			imageURL = Arrays.asList(this.productImages.split(","));

		imageURLs = new ArrayList<String>();
		Optional.ofNullable(imageURL).ifPresent(eliments -> eliments.forEach(name -> {
			if (!name.contains(".")) {
				name = name + ".jpg";
			}
			this.imageURLs.add(PropertyUtils.IMAGE_BASE_URL + productName + "_" + name);
		}));
	}

	public List<String> getImageURLs() {
		setURL();
		return this.imageURLs;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProduSubctCategory() {
		return produSubctCategory;
	}

	public void setProduSubctCategory(String produSubctCategory) {
		this.produSubctCategory = produSubctCategory;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}