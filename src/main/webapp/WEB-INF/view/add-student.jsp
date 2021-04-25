<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Student</title>
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