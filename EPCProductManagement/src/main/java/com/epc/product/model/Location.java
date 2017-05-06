package com.epc.product.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private int locationId;

	@Column(name="LOCATION_ACTIVE")
	private String locationActive;

	@Column(name="LOCATION_MESSAGE")
	private String locationMessage;

	@Column(name="LOCATION_NAME")
	private String locationName;

	@Column(name="LOCATION_STATE")
	private String locationState;

	@Column(name="LOCATION_ZIP")
	private int locationZip;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationActive() {
		return this.locationActive;
	}

	public void setLocationActive(String locationActive) {
		this.locationActive = locationActive;
	}

	public String getLocationMessage() {
		return this.locationMessage;
	}

	public void setLocationMessage(String locationMessage) {
		this.locationMessage = locationMessage;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationState() {
		return this.locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public int getLocationZip() {
		return this.locationZip;
	}

	public void setLocationZip(int locationZip) {
		this.locationZip = locationZip;
	}

}