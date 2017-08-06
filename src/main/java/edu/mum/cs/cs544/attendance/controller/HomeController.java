package edu.mum.cs.cs544.attendance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value= "/", method=RequestMethod.GET)
	public String redirectRoot() {
		return "Restful Web services";
	}
}
