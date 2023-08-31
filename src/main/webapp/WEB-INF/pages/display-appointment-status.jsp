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
		List<AppointmentData> appointmentData = (List<AppointmentData>) request.getAttribute("listOfData");
	%>
	<% if(appointment!=null) { %>
		<h3 id="h3">Tracking details for appointment Id <%= appointment.get().getAppointid() %> is</h3>
		<table>
			<th>Appointment Id</th><th>Patient name</th><th>Patient Age</th><th>Appointment date</th><th>Symptoms</th><th>Consulting-Doctor</th><th>Doctor specialist in</th><th>Status</th>
				<tr>
					<td><%= appointment.get().getAppointid() %></td>
					<td><%= appointment.get().getPname() %></td>
					<td><%= appointment.get().getPage() %></td>
					<td><%= appointment.get().getAdate() %></td>
					<td><%= appointment.get().getPsymptoms()%></td>
					<td><%= appointment.get().getDname() %></td>
					<td><%= appointment.get().getDspecialist() %></td>
					<td id="status"><%= appointment.get().getAppointmentStatus().getStatus() %></td>
				</tr>
			</table>
			
			<% }
			
			else if(appointmentData!=null){ %>
				<h3 id="h3">List of appointments you're consulted with us</h3>
				<table>
					<%int noOfRow = appointmentData.size(), rowcount=0;%>
					<th>Appointment Id</th><th>Patient name</th><th>Patient Age</th><th>Appointment date</th><th>Symptoms</th><th>Consulting-Doctor</th><th>Doctor specialist in</th><th>Status</th>
					<% for(rowcount=0; rowcount <noOfRow; rowcount++) {%>
						<tr>
							<% AppointmentData data = (AppointmentData) appointmentData.get(rowcount); %>
								<td><%= data.getAppointid() %></td>
								<td><%= data.getPname() %></td>
								<td><%= data.getPage() %></td>
								<td><%= data.getAdate() %></td>
								<td><%= data.getPsymptoms()%></td>
								<td><%= data.getDname()    %></td>
								<td><%= data.getDspecialist() %></td>
								<td><%= data.getAppointmentStatus().getStatus() %></td>
						</tr>
					<% } %>		
				</table>
					
			<% }else{%>
				<h3 id="h3" style="color:red;">No records found! please take consultation with us from next time</h3>
			<%} %>
				
	</table>
	<%@ include file="./footer.jsp" %>
</body>
</html>