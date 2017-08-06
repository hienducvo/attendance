package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Session;
import edu.mum.cs.cs544.attendance.entity.Student;

public interface SessionDAO extends BaseDAO<Session> {
	
	public List<Session> getAll();
	List<Student> getStudentBySessionId(int sessionId);
	List<Session> getSessionByCourseOfferingId(String courseOfferingId);

}
