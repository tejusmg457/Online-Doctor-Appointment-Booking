<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String demail = (String) request.getAttribute("demail"); %>
	<h1>doctor dashboard</h1>
	<h3>Welcome Doctor <%= demail %></h3>
	<% session.setAttribute("demail", demail); %>
	<form action="listOfPendingAppointments" method="get"><button name="demail" value="<%= demail %>">List of Appointments</button></form>
</body>
</html>