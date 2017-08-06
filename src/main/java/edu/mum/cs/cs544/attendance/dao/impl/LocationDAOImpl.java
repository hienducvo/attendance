package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.LocationDAO;
import edu.mum.cs.cs544.attendance.entity.Location;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class LocationDAOImpl extends BaseDAOImpl<Location> implements LocationDAO{

	@SuppressWarnings("unchecked")
	public List<Location> getAll(){
		Query query= (Query) sessionFactory.getCurrentSession().createQuery("Select l from Location l");
		return new ArrayList<Location>(query.list());
				
	}
	
}
