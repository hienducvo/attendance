package edu.mum.cs.cs544.attendance.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs544.attendance.entity.Admin;
import edu.mum.cs.cs544.attendance.entity.Faculty;
import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.AdminService;
import edu.mum.cs.cs544.attendance.service.FacultyService;
import edu.mum.cs.cs544.attendance.service.StudentService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "admin/student/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addStudent(@RequestBody @Valid Student studentDTO, BindingResult result) {
		
		Admin admin = new Admin();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(Field field: admin.getClass().getDeclaredFields()){
			map.put(field.getName(), field.get(admin));
		}
		

		TimesheetResponse response = new TimesheetResponse();

		try {

			if (!result.hasErrors()) {
				Student student = studentService.addStudent(studentDTO);

				response.setResult(student);
				response.setStatus(Constants.SUCCESS_CODE);
				response.setMessage(Constants.SUCCESS_MESSAGE);

			} else {
				Constants.validateError(response, result);
			}

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/student/update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse updateStudent(@RequestBody @Valid Student studentDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if (result.hasErrors()) {
				Student student = studentService.updateStudent(studentDTO);

				response.setResult(student);
				response.setStatus(Constants.SUCCESS_CODE);
				response.setMessage(Constants.SUCCESS_MESSAGE);

			} else {
				Constants.validateError(response, result);
			}

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/student/delete/{studentId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public TimesheetResponse deleteStudent(@PathVariable String studentId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = studentService.deleteStudentById(studentId);

			response.setResult(success);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/student/all", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getAllStudents() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Student> students = studentService.getAllStudents();
			response.setResult(students);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/faculty/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addFaculty(@RequestBody @Valid Faculty facultyDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {
			if (!result.hasErrors()) {
				Faculty faculty = facultyService.addFaculty(facultyDTO);

				response.setResult(faculty);
				response.setStatus(Constants.SUCCESS_CODE);
				response.setMessage(Constants.SUCCESS_MESSAGE);

			} else {
				Constants.validateError(response, result);
			}

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/faculty/update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse updateFaculty(@RequestBody @Valid Faculty facultyDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if(!result.hasErrors()){
				Faculty faculty = facultyService.updateFaculty(facultyDTO);

				response.setResult(faculty);
				response.setStatus(Constants.SUCCESS_CODE);
				response.setMessage(Constants.SUCCESS_MESSAGE);

			}else{
				Constants.validateError(response, result);
			}
			
			
		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/faculty/delete/{facultyId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public TimesheetResponse deleteFaculty(@PathVariable String facultyId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = facultyService.deleteFacultyById(facultyId);

			response.setResult(success);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/faculty/all", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getAllFaculties() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Faculty> faculties = facultyService.getAllFaculties();
			response.setResult(faculties);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/admin/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addAdmin(@RequestBody @Valid Admin adminDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if(!result.hasErrors()){
				Admin admin = adminService.addAdmin(adminDTO);

				response.setResult(admin);
				response.setStatus(Constants.SUCCESS_CODE);
				response.setMessage(Constants.SUCCESS_MESSAGE);

			}else{
				Constants.validateError(response, result);
			}
			
		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/admin/update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse updateAdmin(@RequestBody  @Valid Admin adminDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if(!result.hasErrors()){
				Admin admin = adminService.updateAdmin(adminDTO);

				response.setResult(admin);
				response.setStatus(Constants.SUCCESS_CODE);
				response.setMessage(Constants.SUCCESS_MESSAGE);

			}else{
				Constants.validateError(response, result);
			}
			
		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/admin/delete/{adminId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public TimesheetResponse deleteAdmin(@PathVariable int adminId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = adminService.deleteAdminById(adminId);

			response.setResult(success);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/admin/all", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getAdmins() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Admin> admins = adminService.getAllAdmins();
			response.setResult(admins);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}
}
