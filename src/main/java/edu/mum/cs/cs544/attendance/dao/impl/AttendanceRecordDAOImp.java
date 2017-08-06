package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.AttendanceRecordDAO;
import edu.mum.cs.cs544.attendance.entity.AttendanceRecord;
import edu.mum.cs.cs544.attendance.entity.Student;

@Transactional(propagation= Propagation.MANDATORY)
@Repository
public class AttendanceRecordDAOImp extends BaseDAOImpl<AttendanceRecord> implements AttendanceRecordDAO {

	@SuppressWarnings("unchecked")
	public List<AttendanceRecord> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT a from AttendanceRecord a");
		return new ArrayList<AttendanceRecord>(query.list());

	}

	@SuppressWarnings("unchecked")
	public List<AttendanceRecord> getByStudentId(String studentId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from AttendanceRecord a where a.student.studentId = :studentId");
        query.setParameter("studentId", studentId);		
		return query.list();		
	}
	
	/*TableA
    JOIN TableB
        ON TableB.aID = TableA.aID*/
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudentByCourseOffering(String courseOfferingId) {
        Query query = sessionFactory.getCurrentSession().createQuery(" select a.student from AttendanceRecord a , Student s , Registration R Where a.student.studentId=s.studentId and s.studentId = R.student.studentId and R.courseOffering.courseOfferingId= :courseOfferingId");
        query.setParameter("courseOfferingId", courseOfferingId);		
		return query.list();		
	}
	@SuppressWarnings("unchecked")
	public List<AttendanceRecord> getAttendanceRecordsForFaculty(String studentId,String courseOfferingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct a from AttendanceRecord a,Student s,Registration r "
        		+ "where a.student.studentId =:studentId "
        		+ "and a.student.studentId=s.studentId "
        		+ "and s.studentId=r.student.studentId "
        		+ "and r.courseOffering.courseOfferingId=:courseOfferingId");
        query.setParameter("studentId", studentId);	
        query.setParameter("courseOfferingId", courseOfferingId);	
		return query.list();
		//cool
	}
	
}