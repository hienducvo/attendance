package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.FacultyDAO;
import edu.mum.cs.cs544.attendance.entity.Faculty;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class FacultyDAOImpl extends BaseDAOImpl<Faculty> implements FacultyDAO{

	@SuppressWarnings("unchecked")
	public List<Faculty> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT f from Faculty f");
		return new ArrayList<Faculty>(query.list());
	}

}
