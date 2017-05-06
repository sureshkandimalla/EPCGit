package com.epc.product.config;

public class PropertyUtils {
        public static final String IMAGE_BASE_URL="https://s3.amazonaws.com/epc-ui/products/";
        public static final String DB_URL = "db.url";
    	public static final String DB_PASSWORD = "db.password";
    	public static final String DB_USER = "db.user";
    	public static final String DB_INITIAL_POOL_SIZE = "db.initialPoolSize";
    	public static final String DB_MAX_POOL_SIZE = "db.maxPoolSize";
    	
    	public static final String getProductsSelectQuery() {
    		return "SELECT   PRODUCT_ID , PRODUCT_NAME , ISACTIVE , PRODUCT_TITLE , PRODUCT_DSCRIPTION , PRODUCT_TYPE , PRODUCT_PRICE , PRODUCT_WEIGHT , PRODUCT_SKU , PRODUCT_CATEGORY_ID , PRODUCT_IMAGES , PRODUCT_PRICE_COMPAREAT  FROM epc.PRODUCTS";
    	}
    	public static final String getProductsInsertQuery() {
    		return "INSERT INTO  epc.PRODUCTS ( PRODUCT_ID , PRODUCT_NAME , ISACTIVE , PRODUCT_TITLE , PRODUCT_DSCRIPTION , PRODUCT_TYPE , PRODUCT_PRICE , PRODUCT_WEIGHT , PRODUCT_SKU , PRODUCT_CATEGORY_ID , PRODUCT_IMAGES , PRODUCT_PRICE_COMPAREAT ) VALUES ( ?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
    	}
    	public static final String getLocationsSelectQuery() {
    		return "SELECT LOCATION_ID,LOCATION_NAME,LOCATION_ZIP,LOCATION_STATE,LOCATION_ACTIVE,LOCATION_MESSAGE FROM epc.LOCATIONS";
    	}
    	
}
