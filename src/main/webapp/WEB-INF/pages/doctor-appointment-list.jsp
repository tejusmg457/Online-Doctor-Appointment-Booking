<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.AppointmentData"%> <%@ page import="java.util.List" %> <%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending appointments</title>

<style>

*{margin: 0px; padding:0px;}
body{background-color: lightyellow;}
.target{ text-align: center; width: 1030px; margin-left: 250px;}
table{ border:2px solid black; background-color: lightyellow; margin-left: 185px; margin-top: 25px; box-shadow: 10px 10px 10px silver;}
table th{ padding:10px; color:navy; font-weight: bold;}
table td{padding:10px}
#h3{text-align: center; color:navy; font-weight: bold; margin-top: 15px}
.approvebutton{ padding:2px; font-weight: bold; color: green;}
.noappointments{ text-align: center; color:navy; font-weight: bold; margin-top: 15px;}
#h4{ color:navy; text-align: center; font-weight: bold; margin-top: 25px;}
</style>

</head>
<body>
	<%@ include file="./header.jsp" %>
	
	<% List<AppointmentData> appointmentData = (List) request.getAttribute("appointmentData"); 
	
	 String result = (String) request.getAttribute("result"); 
	 String demail = (String) session.getAttribute("demail"); 
	 
	 if(appointmentData.isEmpty() && true) {  %>
		<h3 class="noappointments"> All appointments are approved no pending </h3>
	<% }
	
	else { %>
	<div class="target">
		<h3 id="h3">List of appointments pending to approve are below</h3>
			<table>
				<th>Appointment ID</th><th>Patient name</th><th>Patient Age</th><th>Appointment date</th><th>Symptoms</th><th>Approve</th>
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
						<td><form action="./approveAppointment"><button class="approvebutton" name="appointmentId" value="<%= data.getAppointid() %>">Approve</button></form></td>
					</tr>
				<% } %>
			</table>
		<% } %>
	</div>
		<%
			String msg =(String) request.getAttribute("msg"); 
		 %> 
		 <%
		   	 if(msg!=null){ %> 
		   	 	<h4 id="h4"><%= msg%></h4>
		<%} %>
		
		<%@ include file="./footer.jsp" %>
</body>
</html>