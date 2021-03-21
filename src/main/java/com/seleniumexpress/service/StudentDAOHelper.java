package com.seleniumexpress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAO;

@Service("studentDAOHelper")
public class StudentDAOHelper {

	@Autowired
	private StudentDAO studentDAOImpl;
	
	public void setUpStudentTable() {

		int roolNo = 21;
		
		List<Student> students = createListOfStudents(roolNo);
		
		studentDAOImpl.insert(students);
	}

	public List<Student> createListOfStudents(int roolNo) {
		List<Student> students = new ArrayList<Student>();

		students.add(getStudent((roolNo++), "Paul", "Tarsus"));
		students.add(getStudent((roolNo++), "Philip", "Tarsus"));
		students.add(getStudent((roolNo++), "Judas", "NOT Iscariot"));
		students.add(getStudent((roolNo++), "Bartholemew", "Bethlehem"));
		students.add(getStudent((roolNo++), "John", "Galilee"));
		students.add(getStudent((roolNo++), "Peter", "Galilee"));
		students.add(getStudent((roolNo++), "David", "Bethlehem"));
		students.add(getStudent((roolNo++), "Thomas", "Jerusalem"));
		students.add(getStudent((roolNo++), "Paul", "Jerusalem"));
		return students;
	}
	
	private static Student getStudent(int roolno, String name, String address) {
		Student newStudent1 = new Student();
		newStudent1.setRoolno(roolno);
		newStudent1.setName(name);
		newStudent1.setAddress(address);
		return newStudent1;
	}
	
	public void printStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}
}
