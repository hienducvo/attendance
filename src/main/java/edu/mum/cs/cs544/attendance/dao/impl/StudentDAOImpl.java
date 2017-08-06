package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.StudentDAO;
import edu.mum.cs.cs544.attendance.entity.Student;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class StudentDAOImpl extends BaseDAOImpl<Student> implements StudentDAO{

	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT t from Student t");
		return new ArrayList<Student>(query.list());
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudentByCourseId(String courseId) {
        Query query = sessionFactory.getCurrentSession().createQuery(""
        		+ "select s.barCode, s.firstName,s.lastName from AttendanceRecord a, Student s,"
        		+ " Registration r,CourseOffering co"
        		+ "  where a.student.studentId=s.studentId AND s.studentId=r.student.studentId AND "
        		+ "r.courseOffering.courseOfferingId=co.courseOfferingId AND co.course.courseId=:courseId ");
        query.setParameter("courseId", courseId);		
		return query.list();		
	}

}
