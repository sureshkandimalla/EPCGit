package com.epc.product.domain;

import java.io.Serializable;

import com.epc.product.model.Location;


public class UILocation implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private boolean active;

	private String Message;
	private String city;

	private String state;

	private int zip;

	public UILocation() {
	}
	public UILocation(Location locationModel) {
		if(locationModel!=null){
		this.city=locationModel.getLocationName();
		this.id=locationModel.getLocationId();
		this.Message=locationModel.getLocationMessage();
		this.zip=locationModel.getLocationZip();
		this.active="Y".equalsIgnoreCase(locationModel.getLocationActive())?true:false;
		this.state=locationModel.getLocationState();
		}
	}
	

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean locationActive) {
		this.active = locationActive;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int locationId) {
		this.id = locationId;
	}

}