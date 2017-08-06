package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.AdminDAO;
import edu.mum.cs.cs544.attendance.entity.Admin;
import edu.mum.cs.cs544.attendance.service.AdminService;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	public Admin addAdmin(Admin admin) {
		return adminDAO.add(admin);
	}

	public Admin updateAdmin(Admin admin) {
		return adminDAO.update(admin);
	}

	public boolean deleteAdminById(int id) {
		return adminDAO.delete(id);
	}

	public Admin getAdminById(int id) {
		return adminDAO.get(id);
	}

	public List<Admin> getAllAdmins() {
		return adminDAO.getAll();
	}

}
