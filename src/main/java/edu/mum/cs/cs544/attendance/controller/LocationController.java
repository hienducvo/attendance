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

import edu.mum.cs.cs544.attendance.entity.Location;
import edu.mum.cs.cs544.attendance.service.LocationService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

	private Logger logger = Logger.getLogger(LocationController.class);

	@Autowired
	LocationService locationService;

	@RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public TimesheetResponse addLocation(@RequestBody @Valid Location locationDTO, BindingResult result) {

		TimesheetResponse response = new TimesheetResponse();
		try {
			if (!result.hasErrors()) {
				Location location = locationService.addLocation(locationDTO);

				response.setResult(location);
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
	public TimesheetResponse updateLocation(@RequestBody @Valid Location locationDTO, BindingResult result) {
		TimesheetResponse response = new TimesheetResponse();
		try {
			if (!result.hasErrors()) {
				Location location = locationService.updateLocation(locationDTO);

				response.setResult(location);
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
	public TimesheetResponse getAllLocations() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Location> locations = locationService.getAllLocations();

			response.setResult(locations);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	@RequestMapping(value = "delete/{locationId}", method = RequestMethod.DELETE, produces = { "application/json" })
	public TimesheetResponse deleteLocation(@PathVariable String locationId) {

		TimesheetResponse response = new TimesheetResponse();

		try {

			boolean success = locationService.deleteLocationById(locationId);

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
