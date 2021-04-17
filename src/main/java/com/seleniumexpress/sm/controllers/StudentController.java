package com.seleniumexpress.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seleniumexpress.sm.DAO.StudentDAO;
import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.service.StudentService;
@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
//	@RequestMapping(value="/showStudent", method=RequestMethod.GET)
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		List<Student> students = studentService.loadStudents();
		model.addAttribute("students", students);
		
//		for(Student student: students) {
//			System.out.println(student);		
//		}
		
		return "student-list";
	}
	
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		
		return "add-student";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		System.out.println("saveStudent : student = "+student);
		
		studentService.saveStudent(student);
		
		return "redirect:/showStudent";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {

		// get Param
		System.out.println("look up student with id :"+id);
		
		Student theStudent = studentService.getStudent(id);
		System.out.println(theStudent);		
		
		model.addAttribute("student", theStudent);		
		
		return "update-student";
	}
	
	@PostMapping("/doUpdateStudent")
	public String doUpdateStudent(Student student) {
		System.out.println("/doUpdateStudent student = "+student);
		
		int numUpdated = studentService.updateStudent(student);
		
		return "redirect:/showStudent";
	}
	
//	@GetMapping("/updateStudent")
//	public String updateStudent(@RequestParam("userId") int id, @ModelAttribute("student") Student student) {
//
//		// get Param
//		System.out.println("look up student with id :"+id);
//		
//		Student theStudent = studentService.getStudent(id);
//		System.out.println(theStudent);
//		
//		student.setId(theStudent.getId());
//		student.setName(theStudent.getName());
//		student.setMobile(theStudent.getMobile());
//		student.setCountry(theStudent.getCountry());
//		
//		return "add-student";
//	}
}
