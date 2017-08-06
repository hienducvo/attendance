package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.LocationDAO;
import edu.mum.cs.cs544.attendance.entity.Location;
import edu.mum.cs.cs544.attendance.service.LocationService;

@Transactional
@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDAO locationDao;
	
	public Location addLocation(Location location) {
		return locationDao.add(location);
	}

	public Location updateLocation(Location location) {
		return locationDao.update(location);
	}

	public boolean deleteLocationById(String id) {
		return locationDao.delete(id);
	}

	public Location getLocationById(String id) {
		return locationDao.get(id);
	}

	public List<Location> getAllLocations() {
		return locationDao.getAll();
	}

	public boolean saveAll(List<Location> locations) {
		return false;
	}

}
