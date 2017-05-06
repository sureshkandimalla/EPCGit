package com.epc.product.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the slider database table.
 * 
 */
@Entity
@NamedQuery(name="Slider.findAll", query="SELECT s FROM Slider s")
public class Slider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SLIDER_ID")
	private int sliderId;

	@Column(name="SLIDER_ACTIVE")
	private String sliderActive;

	@Column(name="SLIDER_CATEGORY_ID")
	private int sliderCategoryId;

	@Column(name="SLIDER_IMAGES")
	private String sliderImages;

	@Column(name="SLIDER_NAME")
	private String sliderName;

	@Column(name="SLIDER_PRODUCT_ID")
	private int sliderProductId;

	@Column(name="SLIDER_TYPE")
	private String sliderType;

	public Slider() {
	}

	public int getSliderId() {
		return this.sliderId;
	}

	public void setSliderId(int sliderId) {
		this.sliderId = sliderId;
	}

	public String getSliderActive() {
		return this.sliderActive;
	}

	public void setSliderActive(String sliderActive) {
		this.sliderActive = sliderActive;
	}

	public int getSliderCategoryId() {
		return this.sliderCategoryId;
	}

	public void setSliderCategoryId(int sliderCategoryId) {
		this.sliderCategoryId = sliderCategoryId;
	}

	public String getSliderImages() {
		return this.sliderImages;
	}

	public void setSliderImages(String sliderImages) {
		this.sliderImages = sliderImages;
	}

	public String getSliderName() {
		return this.sliderName;
	}

	public void setSliderName(String sliderName) {
		this.sliderName = sliderName;
	}

	public int getSliderProductId() {
		return this.sliderProductId;
	}

	public void setSliderProductId(int sliderProductId) {
		this.sliderProductId = sliderProductId;
	}

	public String getSliderType() {
		return this.sliderType;
	}

	public void setSliderType(String sliderType) {
		this.sliderType = sliderType;
	}

}