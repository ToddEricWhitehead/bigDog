package com.seleniumexpress.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seleniumexpress.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet res, int rowNum) throws SQLException {
		
		Student student = new Student();
		
		student.setRoolno(res.getInt("ROOL_NO"));
		student.setName(res.getString("STUDENT_NAME"));
		student.setAddress(res.getString("STUDENT_ADDRESS"));
		
		System.out.println("mapRow() called Student : "+student);
		
		return student;
	}


}
