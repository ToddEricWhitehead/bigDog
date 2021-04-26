<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/5.0.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"></script>
<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
-->
<link rel="stylesheet" type="text/css" href="/student-management-bigdog/URLToReachResourcesFolder/css/my-style-sheet.css">

</head>
<body class="myFonts">

 <h1 align="center">Students </h1>

 <div align="center">
 <!--  modelAttribute="student"   -->
  <form action="showAddStudentPage">
  	<input type="submit" value="ADD" class="button btn-primary"/>
  </form>
  <br/>
 
  <table border="1" class="table table-striped">
    <thead>
     <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Mobile</th>
      <th>Country</th>
      <th>Update</th>
      <th>Delete</th>
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
  
  <!--  <img alt="fake students photo" src="/student-management-bigdog/URLToReachResourcesFolder/images/girl.jpg" />  -->   
  <img alt="fake students photo" src="/student-management-bigdog/URLToReachResourcesFolder/images/girl_dog.jpg" />
  
 </div>
</body>
</html>