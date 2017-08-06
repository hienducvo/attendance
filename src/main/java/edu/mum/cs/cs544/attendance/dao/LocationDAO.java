package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Location;

public interface LocationDAO extends BaseDAO<Location>{
	List<Location> getAll();
}
