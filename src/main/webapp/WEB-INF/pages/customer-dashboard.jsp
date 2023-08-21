<%@ page isELIgnored="false"%> <%@ page session="true"%>
<%@page import="in.ineuron.model.AppointmentData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%> <%@ page import="java.util.Optional"%> <%@ page import="java.time.LocalDateTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient dashboard</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/customerdashboard.css">
</head>
<body>
	<%@ include file="./header.jsp" %>

	<% 
	
	String[] docNames = (String[])session.getAttribute("docNames");
	String[] docSpecialists = (String[])session.getAttribute("docSpecialists");
	
	int hour = LocalDateTime.now().getHour();
	String wish=null;
	if(hour<12)
		wish="Good morning!";
	else if(hour<16)
		wish="Good afternoon!";
	else
		wish="Good evening";
	%>
	<h2 id="ribbon">Customer Dashboard</h2>
	
	<div class="wish">
		<h3 id="wishMsg"><%= wish %></h3>
		<h3 id="name"><%= session.getAttribute("cname") %></h3>
	</div>
	
	<form action="../customer/logout">
		<button class="logout">Logout</button>
	</form>

	<form action="../customer/book-appointment">
		<button class="bookAppointment" >Book appointment</button>
	</form>
	
	<div class="slot">
		<h3 id="slot">Check  slot availability</h3>
		<form action="../customer/checkslot">
			<table class="slotTable">
				<tr>
					<td>Consulting Doctor</td> <td><select name="dname">
											<% if(docNames!=null){ 
											for(int i=0; i<docNames.length; i++){ %>
											<option><%= docNames[i] %></option>
										  	<% }} %>
										</select>
									</td>
				</tr>
				
				<tr>
					<td>Doctor specialist</td> <td><select name="dspecialist">
										<% if(docSpecialists!=null){for(int i=0; i<docSpecialists.length; i++){ %>
											<option><%= docSpecialists[i] %></option>
										 <% }} %>	
										</select>
									</td>
				</tr>
				<tr>
					<td>Date looking for</td> <td><input type="date" name="adate" ></td>
				</tr>
			</table>
			<button class="slotButton">Check</button>
		</form>
		<%
			String msg =(String) request.getAttribute("msg"); 
			
		if(msg!=null){  %>  
				<h4 id="msg"><%= msg %> </h4> 
	<%} %> 
	</div>
	
	<div class="status">
		<h3 id="status" >Find appointment status</h3>
			<form action="../customer/getAppointmentStatus">
				<input type="text" name="appointid" placeholder="Enter Appointment ID"><button class="statusButton">Get Status</button>
			</form>
	</div>
	<div class="statusResult">
			<%
				Optional<AppointmentData> appointment = (Optional<AppointmentData>) request.getAttribute("data");
			%>
				<%if(appointment!=null){ %>
					<table class="statusResultTable">
						<tr>
							<td>Appointment Id </td><td><%= appointment.get().getAppointid() %></td>
						</tr>	
						<tr>
							<td>Patient name </td><td><%= appointment.get().getPname() %></td>
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
							<td>Docter specialist in</td><td><%= appointment.get().getDspecialist() %></td>
						</tr>
						<tr>
							<td>Status of appointment</td><td><%= appointment.get().getAppointmentStatus().getStatus() %></td>
						</tr>
				  </table>
			 <%}else{ %>
				  
			  <%} %>
	</div>		
	
	<%@ include file="./footer.jsp" %>
</body>
</html>


