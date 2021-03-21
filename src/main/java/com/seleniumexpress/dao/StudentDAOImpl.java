package com.seleniumexpress.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.resultsetextractor.StudentAddressResultSetExtractor;
import com.seleniumexpress.resultsetextractor.StudentResultSetExtractor;
import com.seleniumexpress.rowmapper.StudentRowMapper;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

//	@Autowired
	private JdbcTemplate jdbcTemplate;    // = new JdbcTemplate(getDataSource());
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insert(Student student) {
		
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		Object[] arg = {student.getRoolno(),student.getName(),student.getAddress() };
		
		int noOfRowInserted = jdbcTemplate.update(sql, arg);
		
		System.out.println("No of row inserted is " + noOfRowInserted);

	}

	@Override
	public boolean deleteByRollNo(int roolNo) {

		String sql = "DELETE FROM STUDENT WHERE ROOL_NO = ?";

		int noOfRowDeleted = jdbcTemplate.update(sql, roolNo);
		
		System.out.println("No of records deleted is " + noOfRowDeleted);
		
		return noOfRowDeleted == 1;		
		
	}

	@Override
	public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {

		String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDRESS = ?";
		
		int noOfRowsDeleted = jdbcTemplate.update(sql, studentName,studentAddress);
		
		System.out.println("No deleted: "+noOfRowsDeleted+" - deleteRecordByStudentNameOrStudentAddress("+studentName+","+studentAddress+")");
		
		return noOfRowsDeleted;
	}

	@Override
	public void deleteAll() {

		String sql = "TRUNCATE TABLE STUDENT";

		jdbcTemplate.execute(sql);
		
		System.out.println("StudentDAO deleteAll() ");
		
	}

	@Override
	public void insert(List<Student> students) {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
		
		List<Object[]> sqlArgs = new ArrayList<>();
		
		for(Student student : students) {
			Object[] studentData = {student.getRoolno(),student.getName(),student.getAddress()};
			sqlArgs.add(studentData);
		}
		
		jdbcTemplate.batchUpdate(sql, sqlArgs);

		System.out.println("StudentDAO insert list");
		
	}

//	@Override
//	public List<Student> findAllStudents() {
//		
//		String selectSql = "SELECT * FROM STUDENT";
//		
//		List<Student> students = jdbcTemplate.query(selectSql, new StudentRowMapper());
//		
//		return students;
//	}
	
	@Override
	public List<Student> findAllStudents() {

		String selectSql = 
				"SELECT ROOL_NO as roolNo, "		
					+"STUDENT_NAME as name, "
					+"STUDENT_ADDRESS as address "
					+ "FROM STUDENT";
		
		List<Student> students = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<Student>(Student.class));
		
		return students;
	}	

//	@Override
//	public Student findStudentByRollNo(int roolNo) {
//		
//		String selectSql = "SELECT * FROM STUDENT WHERE ROOL_NO = ?";
//		
//		Student student = jdbcTemplate.queryForObject(selectSql, new StudentRowMapper(), roolNo);
//		
//		return student;
//	}

	@Override
	public Student findStudentByRollNo(int roolNo) {
		
		String selectSql = 
				"SELECT ROOL_NO as roolNo, "		
					+"STUDENT_NAME as name, "
					+"STUDENT_ADDRESS as address "
					+ "FROM STUDENT WHERE ROOL_NO = ?";
		
		Student student = jdbcTemplate.queryForObject(selectSql, new BeanPropertyRowMapper<Student>(Student.class), roolNo);
		
		return student;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME = ?";
		
		List<Student> students = jdbcTemplate.query(sql, new StudentResultSetExtractor(), name);
		
		return students;
	}

	@Override
	public Map<String, List<String>> getGroupByAddress() {
		String sql = "select rool_no,student_address, student_name from student group by student_address,student_name,rool_no";
		
		List<Student> students = jdbcTemplate.query(sql, new StudentResultSetExtractor());

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(Student student : students) {
			String key = student.getAddress();
			List<String> valueList = new ArrayList<String>();
			String value = student.getName();
			valueList.add(value);
			List<String> returnedValueList = map.put(key, valueList);
			if (returnedValueList!=null) {
				returnedValueList.add(value);
				map.put(key, returnedValueList);
			}
			System.out.println("key: "+key+": value: "+map.get(key));			
			
		}
		return map;
	}

	@Override
	public Map<String, List<String>> getmGroupStudentsByAddress() {

		String sql = "SELECT * FROM STUDENT";
		
		Map<String, List<String>> studentMap = jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());
		
		System.out.println("getmGroupStudentsByAddress() : "+studentMap);
		
		return null;
	}

	@Override
	public int update(Student student) {
		String sql = "UPDATE STUDENT set STUDENT_ADDRESS = ? WHERE ROOL_NO = ?";

//		int numOfUpdated = jdbcTemplate.update(sql, student.getAddress(), student.getRoolno());
		
		Object[] args = {student.getAddress(), student.getRoolno()};
		
		int numOfUpdated = jdbcTemplate.update(sql, args);
//		int numOfUpdated = jdbcTemplate.update(sql, student);
		
		return numOfUpdated;
	}

	@Override
	@Transactional	
	public int updateStudents(List<Student> students) {
		String sql = "UPDATE STUDENT set STUDENT_ADDRESS = ? WHERE ROOL_NO = ?";
		
		int[] numUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// set args for prepared statement
				ps.setString(1, students.get(i).getAddress());
				ps.setInt(2, students.get(i).getRoolno());

				System.out.println("StudentDAO:updateStudents():getValues() !! : "+students.get(i).getRoolno()+" - "+students.get(i).getAddress());
			}
			
			@Override
			public int getBatchSize() {
				// number of times to execute query
				// setValues()
				
				System.out.println("StudentDAO:updateStudents():getBatchSize() !!!!! : "+students.size());
				
				return students.size();
			}
		});
		
		int sumOfUpdate = 0;
		for(int num: numUpdate) {
			sumOfUpdate += num;
		}
		
		return sumOfUpdate;
	}
	
}
