package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.mum.cs.cs544.attendance.dao.SessionDAO;
import edu.mum.cs.cs544.attendance.entity.Session;
import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.SessionService;

@Transactional
@Service
public class SessionServiceImpl implements SessionService{
	@Autowired
	private SessionDAO sessionDao;

	public Session addSession(Session session) {
		return sessionDao.add(session);
	}

	public Session updateSession(Session session) {
		return sessionDao.update(session);
	}

	public boolean deleteSessionById(int id) {
		return sessionDao.delete(id);
	}

	public Session getSessionById(int id) {
		return sessionDao.get(id);
	}

	public List<Session> getAllSessions() {
		return sessionDao.getAll();
	}

	public boolean saveAll(List<Session> sessions) {
			return false;
	}

	public List<Student> getstudentBySessionId(int sessionId) {
		return sessionDao.getStudentBySessionId(sessionId);
	}

	public List<Session> getSessionbyCourseOfferingId(String courseOfferingId) {
		return sessionDao.getSessionByCourseOfferingId(courseOfferingId);
	}

}
