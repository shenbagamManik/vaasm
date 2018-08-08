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
<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>Student ID</td>
<td>Student Name</td>
<td>Collage</td>
<td>%of Marks</td>

</tr>
<%	try	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@VAASM:1521:xe", "orashen", "shen123");
		Statement st=conn.createStatement();
		out.print(session.getAttribute("sid"));
		ResultSet resultSet  = st.executeQuery("select * from student where stud_id ='"+session.getAttribute("sid")+"'");
		
		
	
		while(resultSet.next()){
			%>
			<tr>
			<td><%=resultSet.getString("stud_id") %></td>
			<td><%=resultSet.getString("stud_name") %></td>
			<td><%=resultSet.getString("stud_collage") %></td>
			<td><%=resultSet.getString("stud_mark") %></td>
			</tr>
		<%}
		}catch(Exception e){
			out.print(e);
		}%>
</table>
</body>
</html>