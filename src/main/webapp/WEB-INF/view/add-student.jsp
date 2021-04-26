<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Student</title>
  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/5.0.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"></script>
<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
-->  
  
  <link rel="stylesheet" type="text/css" href="/student-management-bigdog/URLToReachResourcesFolder/css/add-student.css">
  <link rel="stylesheet" type="text/css" href="/student-management-bigdog/URLToReachResourcesFolder/css/my-style-sheet.css">
</head>
<body class="myFonts">

<div align="center" >
<h1>Add Student</h1>

  <!-- create spring form for data input -->
  <form:form action="save-student" modelAttribute="student" method="POST">

   <table>
    <label>Name :</label>
    <form:input path="name" />
    <br/>
    
    <label>Mobile :</label>
    <form:input path="mobile" />
    <br/>
    
    <label>Country :</label>
    <form:input path="country" />
    <br/>
    
    <input type="submit" value="Submit" />
    <br/>
    </table>

  </form:form>

</div>
</body>
</html>