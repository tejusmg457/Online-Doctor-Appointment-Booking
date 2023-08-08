<%@page import="in.ineuron.model.AppointmentStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %><%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Today's Appointments</title>
</head>
<body>
<h3>this is appointment status</h3>
	<%
		List<AppointmentData> appointments = (List<AppointmentData>) request.getAttribute("data");
		
	%>
	
	<table>
		<%int noOfRow = appointments.size(), rowcount=0; %>	
		<% for(rowcount=0; rowcount <noOfRow; rowcount++){%>
			<tr>
				<% AppointmentData appointment = (AppointmentData) appointments.get(rowcount); %>
				
				<td><%= appointment.getAppointid() %></td>
				<td><%= appointment.getPname() %></td>
				<td><%= appointment.getPage() %></td>
				<td><%= appointment.getAdate() %></td>
				<td><%= appointment.getPsymptoms()%></td>
				<td><%= appointment.getDname() %></td>
				<td><%= appointment.getDspecialist() %></td>
				<td><%= appointment.getAppointmentStatus().getStatus() %></td>
			</tr>
		<% } %>		
	</table>
</body>
</html>