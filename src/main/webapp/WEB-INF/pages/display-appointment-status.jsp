<%@page import="in.ineuron.model.AppointmentStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %><%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of doctors</title>
</head>
<body>
<h3>this is appointment status</h3>
	<%
		Optional<AppointmentData> appointment = (Optional<AppointmentData>) request.getAttribute("data");
		String status = appointment.get().getAppointmentStatus().getStatus();	
	%>
	
	<table>
			<tr>
				<td>Appointment Id </td><td><%= appointment.get().getAppointid() %></td>
			</tr>	
			<tr>
				<td>Patient name </td><td><%= appointment.get().getAppointid() %></td>
			</tr>
			<tr>
				<td>Patient Age </td><td><%= appointment.get().getPage() %></td>
			</tr>
			<tr>
				<td>Appointment Date</td><td><%= appointment.get().getAdate() %></td>
			</tr>
			<tr>
				<td>Symptoms</td><td><%= appointment.get().getPsymptoms()%></td>
			</tr>
			<tr>
				<td>Consulting-Doctor</td><td><%= appointment.get().getDname() %></td>
			</tr>
			<tr>
				<td>Doc specialist in</td><td><%= appointment.get().getDspecialist() %></td>
			</tr>
			<tr>
				<td>Status of appointment</td><td><%= status %></td>
			</tr>
	</table>
</body>
</html>