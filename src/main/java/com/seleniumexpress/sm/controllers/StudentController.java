package com.seleniumexpress.sm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

//	@RequestMapping(value="/showStudent", method=RequestMethod.GET)
	@GetMapping("/showStudent")
	public String showStudentList() {
		
		
		return "student-list";
	}
}
