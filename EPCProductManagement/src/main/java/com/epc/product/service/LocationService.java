package com.epc.product.service;


import java.util.List;

import com.epc.product.domain.UILocation;
import com.epc.product.model.Location;
import com.epc.product.model.Location1;

public interface LocationService {
	
	UILocation findByZipCode(int zipCode);
	UILocation findByCityName(String cityname);
	boolean saveLocations(List<Location> locationList);
	boolean saveLocations();
	List<UILocation> findAllLocations();
	void deleteAllLocations();
	void deActivateLocation(int zipCode);
	void ActivateLocation(int zipCode);
	void addLocation(Location1 location);
	}
