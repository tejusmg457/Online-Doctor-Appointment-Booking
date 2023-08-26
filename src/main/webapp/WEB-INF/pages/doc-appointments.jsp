<%@page import="in.ineuron.model.AppointmentStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %><%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Today's Appointments</title>
<style type="text/css">
	
	*{margin: 0px; padding:0px;}
	body{background-color: lightyellow;}
	.target{ text-align: center; width: 1030px; margin-left: 250px;}
	table{ border:2px solid black; background-color: lightyellow; margin-left: 185px; margin-top: 25px; box-shadow: 10px 10px 10px silver;}
	table th{ padding:10px; color:navy; font-weight: bold;}
	table td{padding:10px}
	#h3{text-align: center; color:navy; font-weight: bold; margin-top: 15px}

</style>
</head>
<body>

	<%@ include file="./header.jsp" %>
	

	<%
		List<AppointmentData> appointments = (List<AppointmentData>) request.getAttribute("data");
		
	%>
	
	<% if(appointments.isEmpty() && true){ %>
		<h3 id="h3">No appointments today! check once in pending section if there any appoval pending</h3>
	<% } 
	
	else{ %>
		<div class="target">
			<h3 id="h3">Today's Appointments</h3>
			<table>
				<%int noOfRow = appointments.size(), rowcount=0; %>
				<th>Appointment ID</th><th>Patient name</th><th>Patient Age</th><th>Appointment date</th><th>Symptoms</th>
				<% for(rowcount=0; rowcount <noOfRow; rowcount++){%>
					<tr>
						<% AppointmentData appointment = (AppointmentData) appointments.get(rowcount); %>
						
						<td><%= appointment.getAppointid() %></td>
						<td><%= appointment.getPname() %></td>
						<td><%= appointment.getPage() %></td>
						<td><%= appointment.getAdate() %></td>
						<td><%= appointment.getPsymptoms()%></td>
					</tr>
				<% } %>		
			</table>
		</div>
	<% } %>
	
	<%@ include file="./footer.jsp" %>
	
</body>
</html>