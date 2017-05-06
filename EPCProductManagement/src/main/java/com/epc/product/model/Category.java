package com.epc.product.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CATEGORY_ID")
	private int categoryId;

	@Column(name="CATEGORY_DESCRIPTION")
	private String categoryDescription;

	@Column(name="CATEGORY_IMAGES")
	private String categoryImages;

	@Column(name="CATEGORY_ISACTIVE")
	private String categoryIsactive;

	@Column(name="CATEGORY_NAME")
	private String categoryName;

	@Column(name="CATEGORY_TITLE")
	private String categoryTitle;

	@Column(name="CATEGORY_TYPE")
	private String categoryType;

	@Column(name="CATEGORY_TYPE_ID")
	private int categoryTypeId;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescription() {
		return this.categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryImages() {
		return this.categoryImages;
	}

	public void setCategoryImages(String categoryImages) {
		this.categoryImages = categoryImages;
	}

	public String getCategoryIsactive() {
		return this.categoryIsactive;
	}

	public void setCategoryIsactive(String categoryIsactive) {
		this.categoryIsactive = categoryIsactive;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryTitle() {
		return this.categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public int getCategoryTypeId() {
		return this.categoryTypeId;
	}

	public void setCategoryTypeId(int categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

}