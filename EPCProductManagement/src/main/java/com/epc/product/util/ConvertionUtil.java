package com.epc.product.util;

import java.util.ArrayList;
import java.util.List;

import com.epc.product.domain.UILocation;
import com.epc.product.domain.UIProduct;
import com.epc.product.model.Location;
import com.epc.product.model.Product;

public class ConvertionUtil {
	public static List<UIProduct> productToUIproduct(List<Product> domainProductList){
		List<UIProduct> returnList=new ArrayList<UIProduct>();
		domainProductList.forEach(domainProduct->{
			returnList.add(productToUIproduct(domainProduct));
		});
		return returnList;
		
	}
public static UIProduct productToUIproduct(Product domainProduct){
	UIProduct uiProduct=null;
	if(domainProduct!=null){
		uiProduct=new UIProduct();
	uiProduct.setActive(domainProduct.getIsactive().equalsIgnoreCase("Y")?true:false);
	uiProduct.setProductCategoryId(domainProduct.getCategory().getCategoryId());
	uiProduct.setProductCategory(domainProduct.getCategory().getCategoryName());
	uiProduct.setProductDscription(domainProduct.getProductDscription());
	uiProduct.setProductId(domainProduct.getProductId());
	uiProduct.setProductImages(domainProduct.getProductImages());
	uiProduct.setProductName(domainProduct.getProductName());
	uiProduct.setProductPrice(domainProduct.getProductPrice());
	uiProduct.setProductPriceCompareat(domainProduct.getProductPriceCompareat());
	uiProduct.setProductSku(domainProduct.getProductSku());
	uiProduct.setProductSubCategoryId(domainProduct.getSubCategory().getCategoryId());
	uiProduct.setProduSubctCategory(domainProduct.getSubCategory().getCategoryName());
	uiProduct.setProductTitle(domainProduct.getProductTitle());
	uiProduct.setProductType(domainProduct.getProductType());
	uiProduct.setProductWeight(domainProduct.getProductWeight());
	}
	return uiProduct;
	
}

public static List<UILocation> locationToUILocation(List<Location> locationModelList){
	List<UILocation> returnList=new ArrayList<UILocation>();
	locationModelList.forEach(locationModel->{
		returnList.add(locationToUILocation(locationModel));
	});
	return returnList;
}
public static UILocation locationToUILocation(Location locationModel){
	UILocation uiLocation=null;
	if(locationModel!=null){
		uiLocation= new UILocation();
		uiLocation.setCity(locationModel.getLocationName());
		uiLocation.setId(locationModel.getLocationId());
		uiLocation.setMessage(locationModel.getLocationMessage());
		uiLocation.setZip(locationModel.getLocationZip());
		uiLocation.setActive("Y".equalsIgnoreCase(locationModel.getLocationActive())?true:false);
		uiLocation.setState(locationModel.getLocationState());
		}
	
	return uiLocation;
	
}
}
