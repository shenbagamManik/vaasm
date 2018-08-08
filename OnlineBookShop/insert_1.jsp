<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.io.*,java.util.*,java.sql.*"%>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Operation</title>
</head>
<body>
<%!String sid; String sname; String scoll; int smark; %>
	<sql:setDataSource var="snapshot" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@VAASM:1521:xe" user="orashen" password="shen123"></sql:setDataSource>
	<%String sid = request.getParameter("sid");
	  String sname = request.getParameter("sname");
	  String scoll = request.getParameter("scoll");
	  int smark = Integer.parseInt(request.getParameter("smark")); %>
	  
	      <c:set var = "stuid" value = "${sid}"/>
	     
	     
	     
	 <sql:update dataSource = "${snapshot}" var = "result">
		insert into student values ("${stuid}","${sname}","${scoll}","${smark}");
	</sql:update>
	<sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from student;
      </sql:query>
	<%out.print("Success fully inserted"); %>
</body>
</html>