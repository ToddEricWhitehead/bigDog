package com.seleniumexpress.api.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Test;

import com.seleniumexpress.sm.DAO.StudentDAO;
import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

@ContextConfiguration(locations = {"classpath:beansEmbedded.xml"})
//@ContextConfiguration(locations = {"classpath:beans.xml"})
//@ComponentScan(basePackages={"com.seleniumexpress"})
public class TestSudentDAOTest {

	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	StudentService studentService;
	
	@Test
	public void test() {
		assertEquals(1, 1);
	}
	
	@Test
	public void getStudents() {
		List<Student> students = studentDAO.loadStudents();
		assertNotNull(students);
		System.out.println("students : "+students);
	}
	
	@Test
	public void getStudentsWithService() {
		List<Student> students = studentService.loadStudents();
		assertNotNull(students);
		System.out.println("studentService.loadStudents : "+students);
	}
	
	@Test
	public void insertStudent() {
		Student student = new Student();
		student.setName("Christ has a vision for me");
		student.setMobile(29109021L);
		student.setCountry("Chili");
		
		studentService.saveStudent(student);		

		List<Student> students = studentService.loadStudents();
		assertNotNull(students);
		System.out.println("studentService.loadStudents : "+students);
	}
	
//	@Test
//	public void setupDeleteInsertStudentDAO() {
//		studentDAO.deleteAll();			
//		studentDAOHelper.setUpStudentTable();
//	}
}
