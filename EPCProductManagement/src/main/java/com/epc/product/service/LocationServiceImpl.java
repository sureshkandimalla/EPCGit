package com.epc.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epc.product.dao.LocationDAO;
import com.epc.product.domain.UILocation;
import com.epc.product.model.Location;
import com.epc.product.model.Location1;
import com.epc.product.util.ConvertionUtil;



@Service("locationService")
public class LocationServiceImpl implements LocationService{
	
	
	@Autowired
	@Qualifier("locationDAO")
	LocationDAO locationDAO;
	public boolean isLocationExist(int zipCode) {
		return findByZipCode(zipCode)!=null;
	}
	
	@Override
	public boolean saveLocations(List<Location> locationList) {
		return locationDAO.saveLocation(locationList);
	}

	
	@Override
	public UILocation findByCityName(String cityname) {
		return ConvertionUtil.locationToUILocation(locationDAO.findLocationByCity(cityname));
	}

	@Override
	public boolean saveLocations() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UILocation> findAllLocations() {
		// TODO Auto-generated method stub
		return ConvertionUtil.locationToUILocation(locationDAO.loadLocations());
	}

	@Override
	public void deleteAllLocations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deActivateLocation(int zipCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActivateLocation(int zipCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLocation(Location1 location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UILocation findByZipCode(int zipCode) {
		// TODO Auto-generated method stub
		return ConvertionUtil.locationToUILocation(locationDAO.findLocationByZip(zipCode));
	}

}
