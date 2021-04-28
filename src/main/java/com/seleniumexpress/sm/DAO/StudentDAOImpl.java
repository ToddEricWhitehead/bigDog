package com.seleniumexpress.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

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

	@Override
	public Student findById(int id) {
		String sql = "Select * from students where id = ?";
		
		Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
		return student;
	}

	@Override
	public Student getStudent(int id) {

		String sql = "Select * from students where id = ?";		
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "Update Students set "
				+"NAME = ?, MOBILE = ?, COUNTRY = ? "
				+"WHERE ID = ?";
		// test SimpleMappingExceptionResolver -> properties.put("java.lang.RuntimeException", "runtimeException"); -- resolver.setExceptionMappings(properties);
//		sql += "kljsdfjas";
		Object args[] = {student.getName(), student.getMobile(), student.getCountry(), student.getId()};
		int numUpdated = jdbcTemplate.update(sql, args);
		return numUpdated;
	}

	@Override
	public int deleteStudent(int id) {
		
		String sql = "delete from students where id = ?";
		
		int numDeleted = jdbcTemplate.update(sql, id);
		
		return id;
	}

}
