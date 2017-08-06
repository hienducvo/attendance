package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.AttendanceRecord;
import edu.mum.cs.cs544.attendance.entity.Student;

public interface AttendanceRecordDAO extends BaseDAO<AttendanceRecord> {
	List<AttendanceRecord> getAll();

	List<AttendanceRecord> getByStudentId(String studentId);
	
	public List<Student> getStudentByCourseOffering(String courseOfferingId);

	List<AttendanceRecord> getAttendanceRecordsForFaculty(String studentId, String courseId);

}
