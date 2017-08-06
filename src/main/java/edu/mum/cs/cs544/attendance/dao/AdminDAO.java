package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Admin;

public interface AdminDAO extends BaseDAO<Admin> {
	
	public List<Admin> getAll();

}
