package com.seleniumexpress.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet res) throws SQLException, DataAccessException {

		Map<String, List<String>> studentMap = new HashMap<String, List<String>>();

		while(res.next()) {
			String studentAddress = res.getString("STUDENT_ADDRESS");
			String studentName = res.getString("STUDENT_NAME");

			List<String> studentNameList = studentMap.get(studentAddress);

			if(studentNameList == null) {
				studentNameList = new ArrayList<String>();
			} 

			studentNameList.add(studentName);
			studentMap.put(studentAddress, studentNameList);
			
//			System.out.println("StudentAddressResultSetExtractor : studentName="+studentName+", studentAddress="+studentAddress);
//			System.out.println(studentMap);

		}
		return studentMap;
	}

}
