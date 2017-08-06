package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Admin;

public interface AdminService {

	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public boolean deleteAdminById(int id);

	public Admin getAdminById(int id);
	
	public List<Admin> getAllAdmins();
}
