<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
  <div align="center">
	<h3>Delete Student</h3>
	
	<form:form action="doDeleteStudent" modelAttribute="student" method="POST">
		<table>
		 	<tr>
		  		<td><label>Id :</label></td>
		  		<td><form:input path="id" /></td>
		  	</tr>
		  	<tr> 
		  		<td><label>Name :</label></td>
		  		<td><form:input path="name" />
		  	</tr>
		  	<tr> 
		  		<td><label>Mobile :</label></td>
		  		<td><form:input path="mobile" />
		  	</tr>
		  	<tr> 
		  		<td><label>Country :</label></td>
		  		<td><form:input path="country" />
		  	</tr>
		  				
		</table>
		
		<button type="submit">Delete</button>
	</form:form>
  </div>
</body>
</html>