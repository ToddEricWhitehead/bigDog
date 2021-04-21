package com.seleniumexpress.sm.DAO;

import java.util.List;

import com.seleniumexpress.sm.api.Student;

public interface StudentDAO {

	List<Student> loadStudents();
	void saveStudent(Student student);
	Student findById(int id);
	Student getStudent(int id);
	int updateStudent(Student student);
	int deleteStudent(int id);
	
}
