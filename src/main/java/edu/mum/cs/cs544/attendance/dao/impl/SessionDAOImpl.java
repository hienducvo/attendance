package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.SessionDAO;
import edu.mum.cs.cs544.attendance.entity.Session;
import edu.mum.cs.cs544.attendance.entity.Student;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class SessionDAOImpl extends BaseDAOImpl<Session> implements SessionDAO{

	@SuppressWarnings("unchecked")
	public List<Session> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT s from Session s");
		return new ArrayList<Session>(query.list());
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentBySessionId(int sessionId) {
        Query query = sessionFactory.getCurrentSession().createQuery(""
        		+ "select st.barCode,st.firstName,st.lastName from Student st, AttendanceRecord a,Timeslot t,Session s"        		
        		+ "  where a.student.studentId=st.studentId AND a.timeslot.abbreviation=t.abbreviation AND "
        		+ "s.timeslot.abbreviation=t.abbreviation AND s.id=:sessionId ");
        query.setParameter("sessionId", sessionId);		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Session> getSessionByCourseOfferingId(String courseOfferingId) {
		Query query = sessionFactory.getCurrentSession().createQuery("select s.id,s.date from Session s, CourseOffering co"        		
            		+ " where s.courseOffering.courseOfferingId=co.courseOfferingId and co.courseOfferingId=:courseOfferingId ");
        query.setParameter("courseOfferingId", courseOfferingId);		
		return query.list();
	}

}
