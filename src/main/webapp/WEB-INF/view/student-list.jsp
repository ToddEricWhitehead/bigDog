<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>

<link rel="stylesheet" type="text/css" href="/student-management-bigdog/URLToReachResourcesFolder/css/my-style-sheet.css"/>

</head>
<body>

 <h1 align="center">Students </h1>

 <div align="center">
 <!--  modelAttribute="student"   -->
  <form action="/student-management-bigdog/showAddStudentPage">
  	<input type="submit" value="ADD" />
  </form>
  <br/>
 
  <table border="1">
    <thead>
     <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Mobile</th>
      <th>Country</th>
      </th>
     </tr> 
    </thead>
	<c:forEach var="student" items="${students}">
	  <tr>
		<td>${student.id}</td>
		<td>${student.name}</td>
		<td>${student.mobile}</td>
		<td>${student.country}</td>
		<td><a href="/student-management-bigdog/updateStudent?userId=${student.id}">Update</a></td>
		<td><a href="/student-management-bigdog/deleteStudent?userId=${student.id}" onclick="if(!(confirm('Really Delete?'))) return false">Delete</a></td>
	  </tr>		
	</c:forEach>
  </table>
  
  <img alt="fake students photo" src="/student-management-bigdog/URLToReachResourcesFolder/images/girl.jpg" />   
  <img alt="fake students photo" src="/student-management-bigdog/URLToReachResourcesFolder/images/girl_dog.jpg" />
  
 </div>
</body>
</html>