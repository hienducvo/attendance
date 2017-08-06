package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Timeslot;;

public interface TimeslotDAO extends BaseDAO<Timeslot> {
	
	public List<Timeslot> getAll();
}
