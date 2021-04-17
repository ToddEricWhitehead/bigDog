package com.seleniumexpress.sm.service;

import java.util.List;

import com.seleniumexpress.sm.api.Student;

public interface StudentService {

	List<Student> loadStudents();
	
	void saveStudent(Student student);
	Student getStudent(int id);
	int updateStudent(Student student);
}
