package com.seleniumexpress.api.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAO;
import com.seleniumexpress.dao.StudentDAOImpl;
import com.seleniumexpress.service.StudentDAOHelper;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Test:  ApplicationContext loaded in Test.java");

		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);
//		populateStudent(studentDAO);
//		deleteStudent(studentDAO, 10);		
//		studentDAO.deleteRecordByStudentNameOrStudentAddress("John", "Tarsus");
		
		studentDAO.deleteAll();		
		
		StudentDAOHelper studentDAOHelper = context.getBean("studentDAOHelper", StudentDAOHelper.class);
		studentDAOHelper.setUpStudentTable();
		
		List<Student> students = studentDAO.findAllStudents();
		studentDAOHelper.printStudents(students);		
		
		Student student = studentDAO.findStudentByRollNo(21);
		System.out.println("Test:  findStudentByRollNo : "+student);
		
		for(Student stu: students) {
			System.out.println("Test:  fetch one by one : "+studentDAO.findStudentByRollNo(stu.getRoolno()));
		}
		
		List<Student> studentz = studentDAO.findStudentByName("Paul");		
		for(Student stu: studentz) {
			System.out.println("Test:  studentz -> fetch : "+studentDAO.findStudentByRollNo(stu.getRoolno()));
		}
		
		Map<String, List<String>> map = studentDAO.getGroupByAddress();
		System.out.println("Test:  GroupByAddress: "+map);
		

		Map<String, List<String>> mapMGroup = studentDAO.getmGroupStudentsByAddress();
		System.out.println("Test:  mapMGroup -> : "+mapMGroup);
		
		Student studentUpdate = new Student();
		studentUpdate.setAddress("Damascus");
		studentUpdate.setRoolno(22);
		int numOfUpdated = studentDAO.update(studentUpdate);
		System.out.println("update : "+numOfUpdated);
		System.out.println("student : "+studentDAO.findStudentByRollNo(22));
		

		int roolNo = 21;		
//		List<Student> studenty = studentDAOHelper.createListOfStudents(roolNo);
		List<Student> studenty = new ArrayList<Student>();

		String longString = "1 Paul, an apostle of Jesus Christ by the will of God, to the saints which are at Ephesus, and to the faithful in Christ Jesus:2 Grace be to you, and peace, from God our Father, and from the Lord Jesus Christ.3 Blessed be the God and Father of our Lord Jesus Christ, who hath blessed us with all spiritual blessings in heavenly places in Christ:4 According as he hath chosen us in him before the foundation of the world, that we should be holy and without blame before him in love:5 Having predestinated us unto the adoption of children by Jesus Christ to himself, according to the good pleasure of his will,6 To the praise of the glory of his grace, wherein he hath made us accepted in the beloved.7 In whom we have redemption through his blood, the forgiveness of sins, according to the riches of his grace;";
		String shortString = "Christ in me the hope of Glory";
		studenty.add(getStudent((roolNo++), "Paul", "NOT Iscariot"));
		studenty.add(getStudent((roolNo++), "Philip", shortString));
		studenty.add(getStudent((roolNo++), "Judas", "Bethany"));
		
		int numOfUpdatedy = studentDAO.updateStudents(studenty);
		
		System.out.println("Test: updateStudents : "+numOfUpdatedy);
		
	}

	private static void deleteStudent(StudentDAO studentDAO, int roolNo) {
		boolean isDeleted = studentDAO.deleteByRollNo(roolNo);
		System.out.println("RollNo: "+roolNo+", isDeleted: "+isDeleted);
	}

	private static void populateStudent(StudentDAO studentDAO) {
		int roolNo = 10;
		insertStudent(studentDAO, getStudent((roolNo++), "Philip", "Tarsus"));
		insertStudent(studentDAO, getStudent((roolNo++), "Judas", "NOT Iscariot"));
		insertStudent(studentDAO, getStudent((roolNo++), "Bartholemew", "Bethlehem"));
		insertStudent(studentDAO, getStudent((roolNo++), "John", "Galilee"));
		insertStudent(studentDAO, getStudent((roolNo++), "Peter", "Galilee"));
		insertStudent(studentDAO, getStudent((roolNo++), "David", "Bethlehem"));
		insertStudent(studentDAO, getStudent((roolNo++), "Thomas", "Jerulsalem"));
	}

	private static void insertStudent(StudentDAO studentDAO, Student student) {
		studentDAO.insert(student);
	}

	private static Student getStudent(int roolno, String name, String address) {
		Student newStudent1 = new Student();
		newStudent1.setRoolno(roolno);
		newStudent1.setName(name);
		newStudent1.setAddress(address);
		return newStudent1;
	}
}
