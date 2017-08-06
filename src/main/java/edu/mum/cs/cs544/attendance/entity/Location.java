package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Location {
    @Id
    private String locationId;
    
    @NotEmpty
    private String name;

    public Location() {
    }
    
    public Location(String locationId, String name) {
    	this.locationId = locationId;
        this.name = name;
    }
   

	public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
