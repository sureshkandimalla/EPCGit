package com.epc.product.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epc.product.model.Location1;
import com.epc.product.model.Product1;


public class LocationExtractor implements ResultSetExtractor<List<Location1>> 
{
	Logger logger = Logger.getLogger("appLogger");
	
       public List<Location1> extractData(ResultSet rs) throws SQLException, DataAccessException 
       { 
    	   List<Location1> locationList = new ArrayList<Location1> (10);   
		   Integer recordCount=0;
           try {
        	   while (rs.next()) 
               {
        	   	  logger.info("Number of records read so far" + recordCount);
        	   	Location1 location = new Location1();
        	   	location.setId(rs.getInt("LOCATION_ID"));
        	   	location.setZipCode(rs.getInt("LOCATION_ZIP"));
        	   	location.setCityName(rs.getString("LOCATION_NAME"));
        	   	location.setState(rs.getString("LOCATION_STATE"));
        	   	location.setActive(rs.getString("LOCATION_ACTIVE"));
        	   	location.setMessage(rs.getString("LOCATION_MESSAGE"));
        	   	locationList.add(location);
        	   }

           } catch (SQLRecoverableException e) {
        	   e.printStackTrace();
        	   logger.info("SQLRecoverableException experienced during resultset read: \nCurrent SQL State = " + e.getSQLState());
        	   locationList = null;
        	   throw e;
           }
           catch (SQLException e) {
        	   e.printStackTrace();
        	   logger.info("SQL Exception experienced during resultset read: Current SQL State = " + e.getSQLState()+ ", Error Code = " + e.getErrorCode());
        	   locationList = null;
        	   throw e;
           }
           return locationList;
       }
    
}

