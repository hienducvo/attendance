package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.TimeslotDAO;
import edu.mum.cs.cs544.attendance.entity.Timeslot;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class TimeslotDAOImpl extends BaseDAOImpl<Timeslot> implements TimeslotDAO{

	@SuppressWarnings("unchecked")
	public List<Timeslot> getAll() {
		Query query=sessionFactory.getCurrentSession().createQuery("Select t from Timeslot t");
		return new ArrayList<Timeslot>(query.list());
	}
}
