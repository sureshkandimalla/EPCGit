package com.epc.product.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_ID")
	private int productId;

	private String isactive;

	@Column(name="PRODUCT_DSCRIPTION")
	private String productDscription;

	@Column(name="PRODUCT_IMAGES")
	private String productImages;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_PRICE")
	private BigDecimal productPrice;

	@Column(name="PRODUCT_PRICE_COMPAREAT")
	private BigDecimal productPriceCompareat;

	@Column(name="PRODUCT_SKU")
	private String productSku;


	@Column(name="PRODUCT_TITLE")
	private String productTitle;

	@Column(name="PRODUCT_TYPE")
	private String productType;

	@Column(name="PRODUCT_WEIGHT")
	private BigDecimal productWeight;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="PRODUCT_CATEGORY_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_SUB_CATEGORY_ID")
	private Category subCategory;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}
	

}