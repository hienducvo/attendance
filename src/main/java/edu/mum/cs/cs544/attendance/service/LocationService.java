package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Location;

public interface LocationService {
	public Location addLocation(Location location);

	public Location updateLocation(Location location);

	public boolean deleteLocationById(String id);

	public Location getLocationById(String id);

	public List<Location> getAllLocations();

	public boolean saveAll(List<Location> locations);
}
