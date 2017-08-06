package edu.mum.cs.cs544.attendance.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.StudentService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	private Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addStudent(@Valid @RequestBody Student studentDTO, BindingResult result) {

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

	@RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse updateCourse(@Valid @RequestBody Student studentDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {
			if (!result.hasErrors()) {

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

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getAllStudents() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Student> students = studentService.getAllStudents();

			response.setResult(students);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "{courseId}", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getStudentByCourseId(@PathVariable String courseId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Student> students = studentService.getstudentByCourseId(courseId);

			response.setResult(students);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "delete/{studentId}", method = RequestMethod.DELETE, produces = { "application/json" })
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

}
