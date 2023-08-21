<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.*" %> <%@ page import="java.text.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of appointments</title>
<style>
	*{margin:0px; display:0px;}
	body{background-color: lightcyan;}
	#appointlist {text-align:center; font-weight: bold; margin-top: 25px; color:blue;}
	table{ border:2px solid black; background-color: lightyellow; margin-left: 185px; margin-top: 25px; box-shadow: 10px 10px 10px silver; margin-bottom: 25px;}
	table th{ padding:10px; color:navy; font-weight: bold;}
	table td{padding:10px}
	.footer { position: absolute; margin-top:50px !important; }
		
</style>
</head>
<body>
	<%@ include file="./header.jsp" %>
	<%
		List<AppointmentData> appointments = (List) request.getAttribute("appointments");
		Date fdate = (Date)request.getAttribute("fdate");
		Date tdate = (Date)request.getAttribute("tdate");
		
		Date fromDate = new Date(fdate.getTime()); 
		Date toDate = new Date(tdate.getTime()); 
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		String utilDateFrom = dateFormat.format(fromDate);
		String utilDateTo = dateFormat.format(toDate); 
	%>
	<h3 id="appointlist">List of appointments from <%= utilDateFrom %> to <%= utilDateTo %> </h3>
	<table>
		<%int noOfRow = appointments.size(), rowcount=0; %>	
		<th>Appointment ID</th><th>Patient Name</th><th>Patient age</th><th>Appointment date</th><th>Symptoms</th><th>Consulted doctor</th><th>Doctor specialist in</th><th>Status of appointment</th>
		<% for(rowcount=0; rowcount <noOfRow; rowcount++){%>
			<tr>
				<% AppointmentData appointment = (AppointmentData) appointments.get(rowcount); %>
				
				<td><%= appointment.getAppointid() %></td>
				<td><%= appointment.getPname() %></td>
				<td><%= appointment.getPage() %></td>
				<% Date date = new Date(appointment.getAdate().getTime()); 
				String utilDateAppointment = dateFormat.format(date); %>
				
				<td><%= utilDateAppointment %></td>
				<td><%= appointment.getPsymptoms()%></td>
				<td><%= appointment.getDname() %></td>
				<td><%= appointment.getDspecialist() %></td>
				<td><%= appointment.getAppointmentStatus().getStatus() %></td>
			</tr>
		<% } %>		
	</table>
	
	<div class="footer">
	<%@ include file="./footer.jsp" %>
	</div>
</body>
</html>