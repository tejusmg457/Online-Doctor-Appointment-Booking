<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %> <%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of appointments</title>
</head>
<body>
	<% List<AppointmentData> appointmentData = (List) request.getAttribute("appointmentData"); %>
	<% String result = (String) request.getAttribute("result"); %>
	<% String demail = (String) session.getAttribute("demail"); %>
	<h1>Doc email is <%= demail %></h1>
	
	<table>
		<%int noOfRow = appointmentData.size(), rowcount = 0; %>
		<%for (rowcount=0; rowcount<noOfRow; rowcount++){ %>
			<tr>
				<%AppointmentData data = (AppointmentData) appointmentData.get(rowcount); %>
				<td><%= data.getAppointid() %></td>
				<td><%= data.getPname( )%></td>
				<td><%= data.getPage() %></td>
				<td><%= data.getAdate() %></td>
				<td><%= data.getPsymptoms() %></td>
				<% session.setAttribute("demail", demail); %>
				<td><form action="approveAppointment"><button name="appointmentId" value="<%= data.getAppointid() %>">Approve</button></form></td>
				
			</tr>
		<% } %>
	</table>
	<% if(result!=null) {%>
	<h1>Appointment approved for the id :: <%= result %></h1>
	<%} %>
</body>
</html>