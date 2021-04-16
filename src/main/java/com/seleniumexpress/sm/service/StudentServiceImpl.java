package com.seleniumexpress.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.sm.DAO.StudentDAO;
import com.seleniumexpress.sm.api.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public List<Student> loadStudents() {

		List<Student> students = studentDAO.loadStudents();
		
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		
		// write business logic in the service layer
		if ("UK".equals(student.getCountry())) {
			// send email
			System.out.println("mail sent to : "+student.getName());
		}
		studentDAO.saveStudent(student);
		
	}

	@Override
	public Student getStudent(int id) {
//		Student student = studentDAO.getStudent(id);
		Student student = studentDAO.findById(id);
		return student;
	}

}
