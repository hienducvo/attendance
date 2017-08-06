package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.FacultyDAO;
import edu.mum.cs.cs544.attendance.entity.Faculty;
import edu.mum.cs.cs544.attendance.service.FacultyService;

@Transactional
@Service
public class FacultyServiceImpl implements FacultyService {
	
	@Autowired
	private FacultyDAO facultyDAO;
	public Faculty addFaculty(Faculty faculty) {
		return facultyDAO.add(faculty);
	}

	public Faculty updateFaculty(Faculty faculty) {
		return facultyDAO.update(faculty);
	}

	public boolean deleteFacultyById(String id) {
		return facultyDAO.delete(id);
	}

	public Faculty getFacultyById(String id) {
		return facultyDAO.get(id);
	}

	public List<Faculty> getAllFaculties() {
		return facultyDAO.getAll();
	}

}
