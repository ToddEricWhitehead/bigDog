<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
  <link rel="stylesheet" type="text/css" href="/student-management-bigdog/URLToReachResourcesFolder/css/my-style-sheet.css">
</head>
<body>

<div align="center" >
<h1>Update Student</h1>

  <!-- create spring form for data input -->
  <form:form action="doUpdateStudent" modelAttribute="student" method="POST">

   <table>
   
    <form:hidden path="id" />

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