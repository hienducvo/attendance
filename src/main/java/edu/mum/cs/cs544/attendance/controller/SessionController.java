package edu.mum.cs.cs544.attendance.controller;

import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs544.attendance.entity.Session;
import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.SessionService;

import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
@RequestMapping(value = "/session")
public class SessionController {
	private Logger logger = Logger.getLogger(SessionController.class);

	@Autowired
	SessionService sessionService;

		@RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addSession( @RequestBody Session sessionDTO) {

		TimesheetResponse response = new TimesheetResponse();

		try {
		
			Session session =sessionService.addSession(sessionDTO);

			response.setResult(session);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse updateCourse(@RequestBody Session sessionDTO) {

		TimesheetResponse response = new TimesheetResponse();

		try {
		

			Session session = sessionService.updateSession(sessionDTO);

			response.setResult(session);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);


		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getAllSessions() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Session> sessions = sessionService.getAllSessions();

			response.setResult(sessions);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	
	//list of students who attend a session
	@RequestMapping(value = "{getStudentBySession}", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getStudentBySessionId(@PathVariable int getStudentBySession ) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Student> students = sessionService.getstudentBySessionId(getStudentBySession);

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
	
	
	//session in a specific course offering
	@RequestMapping(value = "courseoffering/{courseOfferingId}", method = RequestMethod.GET, produces = { "application/json" })
	public TimesheetResponse getSessionByCourseOffering(@PathVariable String courseOfferingId ) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Session> sessions = sessionService.getSessionbyCourseOfferingId(courseOfferingId);

			response.setResult(sessions);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	

	@RequestMapping(value = "delete/{sessionId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public TimesheetResponse deleteSession(@PathVariable int sessionId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = sessionService.deleteSessionById(sessionId);

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
