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

import edu.mum.cs.cs544.attendance.entity.AttendanceRecord;
import edu.mum.cs.cs544.attendance.entity.Student;
import edu.mum.cs.cs544.attendance.service.AttendanceRecordService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
@RequestMapping(value= "/attendancerecord")
public class AttendanceRecordController {
	private Logger logger = Logger.getLogger(AttendanceRecordController.class);

	@Autowired
	AttendanceRecordService attendanceRecordService;

	@RequestMapping(value= "/attendancerecord", method=RequestMethod.GET)
	public String redirectRoot() {
		return "Attendance Restful Web service";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {"application/json" })
	public TimesheetResponse addAttendanceRecord(@RequestBody @Valid AttendanceRecord attendanceRecordDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if(!result.hasErrors()){
				AttendanceRecord attendanceRecord = attendanceRecordService.addAttendanceRecord(attendanceRecordDTO);

				response.setResult(attendanceRecord);
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
	
	@RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json", produces = {"application/json" })
	public TimesheetResponse updateCourse(@RequestBody AttendanceRecord attendanceRecordDTO) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			AttendanceRecord attendanceRecord = attendanceRecordService.addAttendanceRecord(attendanceRecordDTO);

			response.setResult(attendanceRecord);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			logger.error(ex);
			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());

		}

		return response;
	}
	@RequestMapping(value = "getbyid/{attendanceRecordsId}", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getByIdAttendanceRecords(@PathVariable String attendanceRecordsId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			AttendanceRecord attendanceRecord = attendanceRecordService.getAttendanceRecordById(attendanceRecordsId);

			response.setResult(attendanceRecord);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getAllCourses() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<AttendanceRecord> attendanceRecords = attendanceRecordService.getAllAttendanceRecord();


			response.setResult(attendanceRecords);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	@RequestMapping(value = "getbystudentid/{studentId}", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getByStudentIdAttendanceRecords(@PathVariable String studentId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<AttendanceRecord> attendanceRecord = attendanceRecordService.getAttendanceRecordByStudnetId(studentId);

			response.setResult(attendanceRecord);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}
	@RequestMapping(value = "delete/{attendanceRecordsId}", method = RequestMethod.DELETE, produces = {"application/json" })
	public TimesheetResponse deleteAttendanceRecords(@PathVariable String attendanceRecordsId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = attendanceRecordService.deleteAttendanceRecordById(attendanceRecordsId);

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
	
	
	@RequestMapping(value = "getstudentsbyoffering/{courseOfferingId}", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getStudentsByCourseOfferingrds(@PathVariable String courseOfferingId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Student> students = attendanceRecordService.getStudentByCourseOffering(courseOfferingId);

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
	@RequestMapping(value = "getAttendanceRecordsForFaculty/{studentId}/{courseOfferingId}", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getAttendanceRecordsForFaculty(@PathVariable String studentId,@PathVariable String courseOfferingId) {

		TimesheetResponse response = new TimesheetResponse();

		try {
			//new update

			List<AttendanceRecord> attendanceRecord = attendanceRecordService.getAttendanceRecordsForFaculty(studentId,courseOfferingId);

			response.setResult(attendanceRecord);
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
