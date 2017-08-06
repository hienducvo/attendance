package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.mum.cs.cs544.attendance.dao.StudentDAO;
import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO studentDao;

	public Student addStudent(Student student) {
		return studentDao.add(student);
	}

	public Student updateStudent(Student student) {
		return studentDao.update(student);
	}

	public boolean deleteStudentById(String id) {
		return studentDao.delete(id);
	}

	public Student getStudentById(String id) {
		return studentDao.get(id);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAll();
	}

	public boolean saveAll(List<Student> students) {
				return false;
	}
	public List<Student> getstudentByCourseId(String courseId) {
		return studentDao.getStudentByCourseId(courseId);
	}

}
