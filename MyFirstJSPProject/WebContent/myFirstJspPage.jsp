<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first JSP Page</title>
</head>
<body>
	<h1>This is my First JSP Page</h1>
	
	<%
		Date d = new Date(); 
		String curDate = d.toString();
	%>
	<h2>The Current Date and time is</h2>
	<h2><%= curDate %></h2>
	
	<h3>This Page is directly under WebContent</h3>
</body>
</html>