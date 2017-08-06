package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.CourseOfferingDAO;
import edu.mum.cs.cs544.attendance.entity.CourseOffering;
import edu.mum.cs.cs544.attendance.service.CourseOfferingService;

@Transactional
@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {

	@Autowired
	private CourseOfferingDAO courseOfferingDAO;
	public CourseOffering addCourse(CourseOffering courseOffering) {
		
		return courseOfferingDAO.add(courseOffering);
	}

	public CourseOffering updateCourseOffering(CourseOffering courseOffering) {
		return courseOfferingDAO.update(courseOffering);
			
	}

	public boolean deleteCourseOfferingById(String id) {
		return courseOfferingDAO.delete(id);
	}

	public CourseOffering getCourseOfferingById(String id) {
		return courseOfferingDAO.get(id);
	}

	public List<CourseOffering> getAllCourseOffering() {
		
		return courseOfferingDAO.getAll();
	}

	public boolean saveAll(List<CourseOffering> courseOffering) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<CourseOffering> getCourseOfferingByCourseId(String courseId) {
		
		return courseOfferingDAO.getCourseOfferingByCourseId(courseId);
	}

}
