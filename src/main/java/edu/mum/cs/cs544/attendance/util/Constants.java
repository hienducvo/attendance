package edu.mum.cs.cs544.attendance.util;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class Constants {
	
	
	public static final int SUCCESS_CODE = 200;
	public static final int ERROR_CODE = 500;
	public static final int ERROR_CODE_CLIENT = 400;
	public static final String SUCCESS_MESSAGE = "Success";
	public static final String ROLE_STUDENT = "ROLE_STUDENT";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_FACULTY = "ROLE_FACULTY";
	
	public static void validateError(TimesheetResponse response, BindingResult result){
		List<ObjectError> errors = result.getAllErrors();
		StringBuffer invalidData = new StringBuffer();
		if (errors != null && !errors.isEmpty()) {
			for (ObjectError error : errors) {
				invalidData.append(error.getDefaultMessage() + " - ");
			}
			
		}
		response.setStatus(ERROR_CODE_CLIENT);
		response.setMessage(invalidData.toString());
	}
	

}
