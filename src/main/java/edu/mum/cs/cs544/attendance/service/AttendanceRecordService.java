package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.AttendanceRecord;
import edu.mum.cs.cs544.attendance.entity.Student;

public interface AttendanceRecordService {
	
	public AttendanceRecord addAttendanceRecord(AttendanceRecord attendanceRecord);

	public AttendanceRecord updateAttendanceRecorde(AttendanceRecord attendanceRecord);

	public boolean deleteAttendanceRecordById(String id);

	public AttendanceRecord getAttendanceRecordById(String id);

	public List<AttendanceRecord> getAllAttendanceRecord();

	public boolean saveAll(List<AttendanceRecord> attendanceRecord);

	public List<AttendanceRecord> getAttendanceRecordByStudnetId(String studentId);
	
	public List<Student> getStudentByCourseOffering(String courseOfferingId);

	public List<AttendanceRecord> getAttendanceRecordsForFaculty(String studentId, String courseId);
	
//cool
}
