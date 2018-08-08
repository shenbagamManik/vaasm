<!--Create a custom tag to extract substring from a given string.
2. Create a form to do the following arithmetic operations.--  +,-,* and /. 
Handle exceptions and display in a error page.  

3. Create a form to get Student id, name, college, %of marks.  Store the data in Oracle database  using jsp tags. 
Retrieve records and display using jsp tags.  -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.io.*,java.util.*,java.sql.*"%>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Register form</title>
</head>
<body>
<form action="insert.jsp" method="post">

<center>
<h3>Student Registration Form</h3>
	<table>
		<tr><td>Student Id</td><td><input type="text" name="sid"></td></tr>
		<tr><td>Student Name</td><td><input type="text" name="sname"></td></tr>
		<tr><td>College</td><td><input type="text" name="scoll"></td></tr>
		<tr><td>% of mark</td><td><input type="text" name="smark"></td></tr>
		<tr><td><input type="submit" value="Submit"></td></tr>
	</table>
</center>
</form>
</body>
</html>