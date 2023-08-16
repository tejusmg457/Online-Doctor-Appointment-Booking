<%@page import="in.ineuron.model.AppointmentStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %><%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment status</title>
<style>
	*{margin:0px; display:0px;}
	body{background-color: lightcyan;}
	#h3 {text-align:center; font-weight: bold; margin-top: 25px; color:blue;}
	table{ border:2px solid black; background-color: lightyellow; margin-left: 220px; margin-top: 25px; box-shadow: 10px 10px 10px silver;}
	table th{ padding:10px; color:navy; font-weight: bold; text-align:center;}
	table td{padding:10px; text-align:center;}
	#status{ font-weight: bolder; }
</style>
</head>
<body>
	<%@ include file="./header.jsp" %>
	<%
		Optional<AppointmentData> appointment = (Optional<AppointmentData>) request.getAttribute("data");
		String status = appointment.get().getAppointmentStatus().getStatus();	
	%>
	<h3 id="h3">Tracking details for appointment Id <%= appointment.get().getAppointid() %> is</h3>
	<table>
			<th>Appointment Id</th><th>Patient name</th><th>Patient Age</th><th>Appointment date</th><th>Symptoms</th><th>Consulting-Doctor</th><th>Doctor specialist in</th><th>Status of appointment</th>
			<tr>
				<td><%= appointment.get().getAppointid() %></td>
				<td><%= appointment.get().getPname() %></td>
				<td><%= appointment.get().getPage() %></td>
				<td><%= appointment.get().getAdate() %></td>
				<td><%= appointment.get().getPsymptoms()%></td>
				<td><%= appointment.get().getDname() %></td>
				<td><%= appointment.get().getDspecialist() %></td>
				<td id="status"><%= status %></td>
			</tr>
	</table>
	<%@ include file="./footer.jsp" %>
</body>
</html>