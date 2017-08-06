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

import edu.mum.cs.cs544.attendance.entity.CourseOffering;
import edu.mum.cs.cs544.attendance.service.CourseOfferingService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
public class CourseOfferingController {

	private Logger logger = Logger.getLogger(CourseOfferingController.class);
	
	@Autowired
	CourseOfferingService courseOfferingService;
/*
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public String redirectRoot() {
		return "Timesheet Restful Web service";
	}*/

	@RequestMapping(value = "admin/offering/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {"application/json" })
	public TimesheetResponse addCourseOffering(@RequestBody @Valid CourseOffering courseOfferingDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if(!result.hasErrors()){
				CourseOffering courseOffering = courseOfferingService.addCourse(courseOfferingDTO);

				response.setResult(courseOffering);
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
	
	@RequestMapping(value = "admin/offering/all", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getAllCoursesOffering() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<CourseOffering> CourseOffering= courseOfferingService.getAllCourseOffering();

			response.setResult(CourseOffering);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	
	@RequestMapping(value = "admin/offering/update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {"application/json" })
	public TimesheetResponse updateCourseOffering(@RequestBody CourseOffering courseOfferingDTO) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			CourseOffering courseOffering = courseOfferingService.updateCourseOffering(courseOfferingDTO);

			response.setResult(courseOffering);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}
	@RequestMapping(value = "admin/offering/delete/{offeringId}", method = RequestMethod.DELETE, produces = {"application/json" })
	public TimesheetResponse deleteCourseOffering(@PathVariable String offeringId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = courseOfferingService.deleteCourseOfferingById(offeringId);

			
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
	
	@RequestMapping(value = "getofferingbyid/{offeringId}", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getCourseOfferingById(@PathVariable String offeringId ) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			CourseOffering courseOffering = courseOfferingService.getCourseOfferingById(offeringId);

			response.setResult(courseOffering );
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	
	@RequestMapping(value = "getofferingbycourseid/{courseId}", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getCourseOfferingBycourseId(@PathVariable String courseId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<CourseOffering> courseOfferings = courseOfferingService.getCourseOfferingByCourseId(courseId);

			response.setResult(courseOfferings);
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
