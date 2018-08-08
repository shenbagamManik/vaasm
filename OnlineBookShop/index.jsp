<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="WEB-INF/mytags.tld"  prefix="m"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extract part of string using tag library</title>
</head>
<body>
	<%-- SubString of Shenbagam is <m:substring mainStr="Shenbagam"></m:substring> --%>
	<form action="OperationContoller" method="post">
	<table>
		<tr><td>Num1</td><td><input type="text" name="num1"></td></tr>
		<tr><td>Num2</td><td><input type="text" name="num2"></td></tr>
		<tr><td>result</td><td><input type="text" name="result" value=<%session.getAttribute("result"); %>></td></tr>
		<tr>
		<td><input type="submit" value="Add" name ="add"></td>
		<td><input type="submit" value="Subtract" name="sub"></td>
		<td><input type="submit" value="Multiply" name="mul"></td>
		<td><input type="submit" value="Divid" name="divid"></td></tr>
	</table>
	</form>
</body>
</html>