package com.epc.product.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.epc.product.model.Product;
import com.epc.product.model.Product1;

public class ProductSetter implements BatchPreparedStatementSetter {
	List<Product> productList;
	public ProductSetter(){
		
	}
public ProductSetter(List<Product> productList){
		this.productList=productList;
	}
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			Product product = productList.get(i);
			ps.setLong(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getIsactive());
			/*ps.setString(4, product.getpTitle());
			ps.setString(5, product.getpDescription());
			ps.setString(6, product.getpType());
			ps.setString(7, product.getpPrice());
			ps.setString(8, product.getpWeight());
			ps.setString(9, product.getpSKU());
			ps.setInt(10, product.getCategoryId());
			//TODO set appropriate
			ps.setString(11, listToString(product.getImageURLs()));
			ps.setString(12, product.getpComparePrice());*/
			
		}

		@Override
		public int getBatchSize() {
			return productList.size();
		}
		private String listToString(List<String> stringList){
			StringBuffer returnStr=new StringBuffer();
			Optional.ofNullable(stringList).ifPresent(eliments ->eliments.forEach(name->{
				if(returnStr.length()>0)
					returnStr.append(","+getImageName(name));
				else
					returnStr.append(getImageName(name));
			}));
			return returnStr.toString();
			
		}
	
		private String getImageName(String imageUrl){
			 List<String> array;
		    	if(imageUrl!=null && imageUrl.length()>0){
		    	   array=Arrays.asList(imageUrl.split("_"));
		    	   return array.get(array.size()-1);
		    	}
		    	else
		    		return null;
	    }
	

}
