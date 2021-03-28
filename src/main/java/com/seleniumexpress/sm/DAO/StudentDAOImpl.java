package com.seleniumexpress.sm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> loadStudents() {
		
		String sql = "SELECT * from STUDENTS";
		
		List<Student> students =  jdbcTemplate.query(sql,  new StudentRowMapper());
		
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		String sql = "INSERT INTO STUDENTS (NAME, MOBILE, COUNTRY) VALUES (?,?,?)";
		
		Object[] args =
			{student.getName(), student.getMobile(), student.getCountry()};
		
		int numInsert = jdbcTemplate.update(sql, args);
		
		System.out.println("saveStudent(Student student) : num "+numInsert);
	}

}
