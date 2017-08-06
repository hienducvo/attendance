package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.AttendanceRecordDAO;
import edu.mum.cs.cs544.attendance.entity.AttendanceRecord;
import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.AttendanceRecordService;

@Transactional
@Service
public class AttendanceRecordServiceImp implements AttendanceRecordService {
	@Autowired
	private AttendanceRecordDAO attendanceRecordDao;

	public AttendanceRecord addAttendanceRecord(AttendanceRecord attendanceRecord) {
		return attendanceRecordDao.add(attendanceRecord);
	}

	public AttendanceRecord updateAttendanceRecorde(AttendanceRecord attendanceRecord) {
		return attendanceRecordDao.update(attendanceRecord);
	}

	public boolean deleteAttendanceRecordById(String id) {
		return attendanceRecordDao.delete(id);
	}

	public AttendanceRecord getAttendanceRecordById(String id) {
		return attendanceRecordDao.get(id);
	}

	public List<AttendanceRecord> getAllAttendanceRecord() {
		return attendanceRecordDao.getAll();
	}

	public boolean saveAll(List<AttendanceRecord> attendanceRecord) {
		return false;
	}

	public List<AttendanceRecord> getAttendanceRecordByStudnetId(String studentId) {
		return attendanceRecordDao.getByStudentId(studentId);
	}
	public List<Student> getStudentByCourseOffering(String courseOfferingId) {
		return attendanceRecordDao.getStudentByCourseOffering(courseOfferingId);
	}
	public List<AttendanceRecord> getAttendanceRecordsForFaculty(String studentId,String courseOfferingId) {
		return attendanceRecordDao.getAttendanceRecordsForFaculty(studentId,courseOfferingId);
		//cool
	}

}
