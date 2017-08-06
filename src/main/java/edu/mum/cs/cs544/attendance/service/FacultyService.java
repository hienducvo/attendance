package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Faculty;

public interface FacultyService {

	public Faculty addFaculty(Faculty faculty);

	public Faculty updateFaculty(Faculty faculty);

	public boolean deleteFacultyById(String id);

	public Faculty getFacultyById(String id);
	
	public List<Faculty> getAllFaculties();
}
