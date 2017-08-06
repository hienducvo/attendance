package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.CourseOfferingDAO;
import edu.mum.cs.cs544.attendance.entity.CourseOffering;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class CourseOfferingDAOImpl extends BaseDAOImpl<CourseOffering> implements CourseOfferingDAO{

	@SuppressWarnings("unchecked")
	public List<CourseOffering> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT co from CourseOffering co");
		return new ArrayList<CourseOffering>(query.list());
		
	}
  
	@SuppressWarnings("unchecked")
	public List<CourseOffering>  getCourseOfferingByCourseId(String courseId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from CourseOffering co Where co.course.courseId= :courseId");
        query.setParameter("courseId", courseId);		
		return query.list();		
	}
}
