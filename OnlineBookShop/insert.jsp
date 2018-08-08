<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.io.*,java.util.*,java.sql.*"%>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Data</title>
</head>
<body>
<%
	String sid=request.getParameter("sid");
	String sname=request.getParameter("sname");
	String scoll=request.getParameter("scoll");
	String smark=request.getParameter("smark");
	session.setAttribute("sid", sid);
	session.setAttribute("sname", sname);
	session.setAttribute("scoll", scoll);
	session.setAttribute("smark", smark);
	try	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@VAASM:1521:xe", "orashen", "shen123");
		Statement st=conn.createStatement();

		int i=st.executeUpdate("insert into student(stud_id,stud_name,stud_collage,stud_mark)values('"+sid+"','"+sname+"','"+scoll+"','"+smark+"')");
		out.println("Data is successfully inserted!");
		response.sendRedirect("display.jsp");
	
	}catch(Exception e){
		out.println(e);
	}
%>
</body>
</html>