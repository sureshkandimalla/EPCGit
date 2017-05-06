package com.epc.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epc.product.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	public Location findByLocationId(int id);
	public Location findByLocationZip(int zip);
	public Location findByLocationName(String city);

}
