<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of doctors</title>
</head>
<body>
	<h3>this is appointment list from to end</h3>
	<%
		List<AppointmentData> appointments = (List) request.getAttribute("appointments");
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