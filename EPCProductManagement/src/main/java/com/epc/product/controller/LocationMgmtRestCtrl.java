package com.epc.product.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epc.product.domain.UILocation;
import com.epc.product.service.LocationService;
import com.epc.product.util.CustomErrorType;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*")
public class LocationMgmtRestCtrl {

	public static final Logger logger = LoggerFactory.getLogger(LocationMgmtRestCtrl.class);

	@Autowired
	@Qualifier("locationService")
	LocationService locationService;
    @CrossOrigin(origins ="*")
	@RequestMapping(value = "/location/{zip}", method = RequestMethod.GET)
	public ResponseEntity<?> getLocation(@PathVariable("zip") int zip) {
		logger.info("Fetching Location by zip PathVariable : ", zip);
		return getLocationByZip(zip);
	}

	@RequestMapping(value = "/location/", method = RequestMethod.GET)
	public ResponseEntity<?> getLocationByZipQ(@QueryParam("zip") Integer zip, @QueryParam("city") String city) {
		logger.info("Fetching Location by zip QueryParam : ", zip);
		if (zip != null)
			return getLocationByZip(zip);
		else if (city != null)
			return getLocationByCity(city);
		else
			return new ResponseEntity<Object>(new CustomErrorType("Method not found"), HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getLocationByCity(String city) {
		logger.info("Fetching Location by zip QueryParam : ", city);
		UILocation location = locationService.findByCityName(city);
		if (location == null) {
			logger.error("City with {} not found.", city);
			return new ResponseEntity<Object>(new CustomErrorType("City with name " + city + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UILocation>(location, HttpStatus.OK);
	}

	@RequestMapping(value = "/locations/", method = RequestMethod.GET)
	public ResponseEntity<?> getLocations() {
		logger.info("Fetching All location ");
		List<UILocation> location = locationService.findAllLocations();
		if (location == null) {
			logger.error("No Locations found");
			return new ResponseEntity<Object>(new CustomErrorType("Locations not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UILocation>>(location, HttpStatus.OK);
	}

	private ResponseEntity<?> getLocationByZip(int zip) {
		logger.info("Fetching Location with id {}", zip);
		UILocation location = locationService.findByZipCode(zip);
		if (location == null) {
			logger.error("ZipCode with id {} not found.", zip);
			return new ResponseEntity<Object>(new CustomErrorType("ZipCode with id " + zip + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UILocation>(location, HttpStatus.OK);
	}

}