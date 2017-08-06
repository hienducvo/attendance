package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.AdminDAO;
import edu.mum.cs.cs544.attendance.entity.Admin;

@Transactional (propagation= Propagation.MANDATORY)
@Repository
public class AdminDAOImpl extends BaseDAOImpl<Admin> implements AdminDAO {

	@SuppressWarnings("unchecked")
	public List<Admin> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT a from Admin a");
		return new ArrayList<Admin>(query.list());
	}

}
