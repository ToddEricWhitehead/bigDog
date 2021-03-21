package com.seleniumexpress.dao;

import java.util.List;
import java.util.Map;

import com.seleniumexpress.api.Student;

public interface StudentDAO {

	void insert(Student student);
	
	void insert(List<Student> students);
	
	boolean deleteByRollNo(int roolNo);
	
	int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);
	
	void deleteAll();
	
	List<Student> findAllStudents();
	
	Student findStudentByRollNo(int roolNo);
	
	List<Student> findStudentByName(String name);
	
	Map<String, List<String>> getGroupByAddress();
	
	Map<String, List<String>> getmGroupStudentsByAddress();
	
	int update(Student student);
	
	int updateStudents(List<Student> students);
}
