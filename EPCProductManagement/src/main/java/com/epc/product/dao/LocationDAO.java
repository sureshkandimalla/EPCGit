package com.epc.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epc.product.model.Location;


public class LocationDAO   {
	@Autowired
	LocationRepository locationRepository;
	public List<Location> loadLocations() {
		return locationRepository.findAll();
	}
	public Location findLocationByZip(int zip) {
		return locationRepository.findByLocationZip(zip);
	}
	public Location findLocationByCity(String city) {
		return locationRepository.findByLocationName(city);
	}
	public boolean saveLocation(List<Location> locationList) {
		return false;	
	}
	/*@Autowired
	@Qualifier("jdbcTemplete")
	public JdbcTemplate jdbcTemplate ;
	LocationExtractor extractor=new LocationExtractor();
	public List<Location1> loadLocations() {
		List<Location1> records = jdbcTemplate.query(PropertyUtils.getLocationsSelectQuery(),extractor);
		System.out.println();
		return records;
	}
	public boolean saveLocation(List<Location1> locationList) {
		jdbcTemplate.batchUpdate(PropertyUtils.getProductsInsertQuery(), new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Location1 location = (Location1) locationList.get(i);
				ps.setLong(1, location.getId());
				ps.setString(2, location.getCityName());
				ps.setString(3, location.getActive());
				ps.setString(4, location.getState());
				ps.setInt(5, location.getZipCode());	
			}

			@Override
			public int getBatchSize() {
				return locationList.size();
			}
		  });
		System.out.println();
		return true;
	}*/
}
