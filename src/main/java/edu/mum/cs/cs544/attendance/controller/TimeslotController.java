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

import edu.mum.cs.cs544.attendance.entity.Timeslot;
import edu.mum.cs.cs544.attendance.service.TimeslotService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
@RequestMapping(value = "/timeslot")
public class TimeslotController {

	private Logger logger = Logger.getLogger(TimeslotController.class);

	@Autowired
	TimeslotService timeslotService;

	@RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addTimeslot(@RequestBody @Valid Timeslot timeslotDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			if (!result.hasErrors()) {
				Timeslot timeslot = timeslotService.addTimeslot(timeslotDTO);

				response.setResult(timeslot);
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
	public TimesheetResponse updatetimeslot(@RequestBody @Valid Timeslot timeslotDTO, BindingResult result) {
		TimesheetResponse response = new TimesheetResponse();
		try {
			if (!result.hasErrors()) {
				Timeslot timeslot = timeslotService.updateTimeslot(timeslotDTO);

				response.setResult(timeslot);
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
	public TimesheetResponse getAlltimeslots() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Timeslot> timeslots = timeslotService.getAllTimeslots();

			response.setResult(timeslots);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "delete/{timeslotId}", method = RequestMethod.DELETE, produces = { "application/json" })
	public TimesheetResponse deletetimeslot(@PathVariable int timeslotId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = timeslotService.deleteTimeslotById(timeslotId);

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
