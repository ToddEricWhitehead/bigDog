package com.seleniumexpress.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seleniumexpress.sm.DAO.StudentDAO;
import com.seleniumexpress.sm.api.Student;

@Controller
public class StudentController {

	@Autowired
	StudentDAO StudentDAO;
	
//	@RequestMapping(value="/showStudent", method=RequestMethod.GET)
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		List<Student> students = StudentDAO.loadStudents();
		model.addAttribute("students", students);
		
		for(Student student: students) {
			System.out.println(student);		
		}
		
		return "student-list";
	}
}
