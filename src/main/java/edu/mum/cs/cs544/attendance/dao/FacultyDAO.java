package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Faculty;

public interface FacultyDAO extends BaseDAO<Faculty>{
	
	List<Faculty> getAll();

}
