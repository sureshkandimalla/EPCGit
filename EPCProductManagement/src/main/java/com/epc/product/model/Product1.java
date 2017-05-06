package com.epc.product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.epc.product.config.PropertyUtils;

public class Product1 {

	private long id;
	private String pName;
	private String pTitle;
	private List<String> imageURLs;
	private String pDescription;
	private String pType;
	private String pVendor;
	private String pPrice;
	private String pComparePrice;
	private String pWeight;
	private String pSKU;
	private String category;
	private Integer categoryId;
	private Boolean active;
	
		public Boolean getActive() {
		if(active!=null)
			return active;
		else
			return false;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

		public Product1(){
		id=0;
	}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getpName() {
			return pName;
		}

		public void setpName(String pName) {
			this.pName = pName;
		}

		public String getpTitle() {
			return pTitle;
		}

		public void setpTitle(String pTitle) {
			this.pTitle = pTitle;
		}

		public List<String> getImageURLs() {
			return imageURLs;
		}

		public void setImageURLs(List<String> imageURL) {
			setURL(imageURL);
			//this.imageURLs = imageURL;
		}

		public String getpDescription() {
			return pDescription;
		}

		public void setpDescription(String pDescription) {
			this.pDescription = pDescription;
		}

		public String getpType() {
			return pType;
		}

		public void setpType(String pType) {
			this.pType = pType;
		}

		public String getpVendor() {
			return pVendor;
		}

		public void setpVendor(String pVendor) {
			this.pVendor = pVendor;
		}

		public String getpPrice() {
			return pPrice;
		}

		public void setpPrice(String pPrice) {
			this.pPrice = pPrice;
		}

		public String getpComparePrice() {
			return pComparePrice;
		}

		public void setpComparePrice(String pComparePrice) {
			this.pComparePrice = pComparePrice;
		}

		public String getpWeight() {
			return pWeight;
		}

		public void setpWeight(String pWeight) {
			this.pWeight = pWeight;
		}

		public String getpSKU() {
			return pSKU;
		}

		public void setpSKU(String pSKU) {
			this.pSKU = pSKU;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public Product1(String pName, String pTitle, List<String> imageURLs, String pType, String pPrice, String category) {
			super();
			this.pName = pName;
			this.pTitle = pTitle;
			this.imageURLs = imageURLs;
			this.pType = pType;
			this.pPrice = pPrice;
			this.category = category;
		}

		public Product1(long id, String pName, String pTitle, List<String> imageURL, String pType, String pPrice,
				String pWeight, String category,Integer categoryId ) {
			super();
			this.id = id;
			this.pName = pName;
			this.pTitle = pTitle;
			setURL(imageURL);
			this.pType = pType;
			this.pPrice = pPrice;
			this.pWeight = pWeight;
			this.category = category;
			this.categoryId=categoryId;
			
		}
		private void setURL(List<String> imageURL){
			if(this.imageURLs==null)
				imageURLs=new ArrayList<String>();
			Optional.ofNullable(imageURL).ifPresent(eliments ->eliments.forEach(name->{
				if(!name.contains("."))
				{
					name=name+".jpg";	
				}
				this.imageURLs.add(PropertyUtils.IMAGE_BASE_URL+pName+"_"+name);
			}));
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((category == null) ? 0 : category.hashCode());
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((imageURLs == null) ? 0 : imageURLs.hashCode());
			result = prime * result + ((pComparePrice == null) ? 0 : pComparePrice.hashCode());
			result = prime * result + ((pDescription == null) ? 0 : pDescription.hashCode());
			result = prime * result + ((pName == null) ? 0 : pName.hashCode());
			result = prime * result + ((pPrice == null) ? 0 : pPrice.hashCode());
			result = prime * result + ((pSKU == null) ? 0 : pSKU.hashCode());
			result = prime * result + ((pTitle == null) ? 0 : pTitle.hashCode());
			result = prime * result + ((pType == null) ? 0 : pType.hashCode());
			result = prime * result + ((pVendor == null) ? 0 : pVendor.hashCode());
			result = prime * result + ((pWeight == null) ? 0 : pWeight.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product1 other = (Product1) obj;
			if (category == null) {
				if (other.category != null)
					return false;
			} else if (!category.equals(other.category))
				return false;
			if (id != other.id)
				return false;
			if (imageURLs == null) {
				if (other.imageURLs != null)
					return false;
			} else if (!imageURLs.equals(other.imageURLs))
				return false;
			if (pComparePrice == null) {
				if (other.pComparePrice != null)
					return false;
			} else if (!pComparePrice.equals(other.pComparePrice))
				return false;
			if (pDescription == null) {
				if (other.pDescription != null)
					return false;
			} else if (!pDescription.equals(other.pDescription))
				return false;
			if (pName == null) {
				if (other.pName != null)
					return false;
			} else if (!pName.equals(other.pName))
				return false;
			if (pPrice == null) {
				if (other.pPrice != null)
					return false;
			} else if (!pPrice.equals(other.pPrice))
				return false;
			if (pSKU == null) {
				if (other.pSKU != null)
					return false;
			} else if (!pSKU.equals(other.pSKU))
				return false;
			if (pTitle == null) {
				if (other.pTitle != null)
					return false;
			} else if (!pTitle.equals(other.pTitle))
				return false;
			if (pType == null) {
				if (other.pType != null)
					return false;
			} else if (!pType.equals(other.pType))
				return false;
			if (pVendor == null) {
				if (other.pVendor != null)
					return false;
			} else if (!pVendor.equals(other.pVendor))
				return false;
			if (pWeight == null) {
				if (other.pWeight != null)
					return false;
			} else if (!pWeight.equals(other.pWeight))
				return false;
			return true;
		}

		public Integer getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", pName=" + pName + ", pTitle=" + pTitle + ", imageURL=" + imageURLs
					+ ", pDescription=" + pDescription + ", pType=" + pType + ", pVendor=" + pVendor + ", pPrice="
					+ pPrice + ", pComparePrice=" + pComparePrice + ", pWeight=" + pWeight + ", pSKU=" + pSKU
					+ ", category=" + category + "]";
		}
		

		
}
