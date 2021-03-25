<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>

 <div>
  <table border="1">
    <thead>
     <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Mobile</th>
      <th>Country</th>
     </tr> 
    </thead>
	<c:forEach var="student" items="${students}">
	  <tr>
		<td>${student.id}</td>
		<td>${student.name}</td>
		<td>${student.mobile}</td>
		<td>${student.country}</td>
	  </tr>		
	</c:forEach>
  </table>
 </div>
</body>
</html>