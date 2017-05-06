package com.epc.product.dao;



import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.epc.product.model.Product;
import com.epc.product.model.Product1;

@Component
public class ProductDataExtractor implements ResultSetExtractor<List<Product>> 
{
	Logger logger = Logger.getLogger("appLogger");
	
       public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException 
       { 
    	   List< Product> productList = new ArrayList<Product> (100000);   
		   Integer recordCount=0;
           try {
        	   while (rs.next()) 
               {
        	   	  logger.info("Number of records read so far" + recordCount);
        	   	  Product product = new Product();
        	      product.setProductId(rs.getInt("PRODUCT_ID"));
        	      product.setProductName(rs.getString("PRODUCT_NAME"));
        	      product.setProductName(rs.getString("PRODUCT_TITLE"));
        	      product.setProductDscription(rs.getString("PRODUCT_DSCRIPTION"));
        	      product.setProductType(rs.getString("PRODUCT_TYPE"));
        	      product.setProductPrice(new BigDecimal(rs.getString("PRODUCT_PRICE")));
        	      product.setProductWeight(new BigDecimal(rs.getString("PRODUCT_WEIGHT")));
        	      product.setProductSku(rs.getString("PRODUCT_SKU"));
        	      /*product.setProductCategoryId(rs.getInt("PRODUCT_CATEGORY_ID"));*/
        	      //product.setImageURLs( getImageList(rs.getString("PRODUCT_IMAGES")));
        	      product.setProductImages(rs.getString("PRODUCT_IMAGES"));
        	      product.setProductPriceCompareat(new BigDecimal(rs.getString("PRODUCT_PRICE_COMPAREAT")));
        	     // product.setpVendor(rs.getString(columnIndex));
        	      productList.add(product);
	        		
               }

           } catch (SQLRecoverableException e) {
        	   e.printStackTrace();
        	   logger.info("SQLRecoverableException experienced during resultset read: \nCurrent SQL State = " + e.getSQLState());
        	   productList = null;
        	   throw e;
           }
           catch (SQLException e) {
        	   e.printStackTrace();
        	   logger.info("SQL Exception experienced during resultset read: Current SQL State = " + e.getSQLState()+ ", Error Code = " + e.getErrorCode());
        	   productList = null;
        	   throw e;
           }
         /* if (recordCount == 0)  {
        	   log.error("No valid records found to process ");
        	   return null;
           }*/
           return productList;
       }
    private List<String> getImageList(String images){
    	if(images!=null && images.length()>0)
    	 return Arrays.asList(images.split(","));
    	else
    		return null;
    }
}

