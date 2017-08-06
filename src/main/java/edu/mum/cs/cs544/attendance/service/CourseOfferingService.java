package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.CourseOffering;

public interface CourseOfferingService {
	
	public CourseOffering addCourse(CourseOffering courseOffering);

	public CourseOffering updateCourseOffering(CourseOffering courseOffering);

	public boolean deleteCourseOfferingById(String id);

	public CourseOffering getCourseOfferingById(String id);

	public List<CourseOffering> getAllCourseOffering();
	
	public List<CourseOffering> getCourseOfferingByCourseId(String courseId);

	public boolean saveAll(List<CourseOffering> courseOffering);

}
