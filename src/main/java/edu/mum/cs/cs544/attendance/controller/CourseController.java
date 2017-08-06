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

import edu.mum.cs.cs544.attendance.entity.Course;
import edu.mum.cs.cs544.attendance.service.CourseService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
public class CourseController {

	private Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "admin/course/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addCourse(@RequestBody @Valid Course courseDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if (!result.hasErrors()) {
				Course course = courseService.addCourse(courseDTO);

				response.setResult(course);
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

	@RequestMapping(value = "admin/course/update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse updateCourse(@RequestBody  @Valid  Course courseDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if (!result.hasErrors()) {
				Course course = courseService.updateCourse(courseDTO);
				response.setResult(course);
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

	@RequestMapping(value = "admin/course/all", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getAllCourses() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Course> courses = courseService.getAllCourses();

			response.setResult(courses);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "admin/course/delete/{courseId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public TimesheetResponse deleteCourse(@PathVariable String courseId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = courseService.deleteCourseById(courseId);

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
