<%@page import="in.ineuron.model.AppointmentData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> <%@ page import="java.util.Optional"%> <%@ page import="java.time.LocalDateTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="./header.jsp" %>
	
	<%String cname = (String) request.getAttribute("dname");
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
		<h3 id="name"><%= cname.toUpperCase() %></h3>
	</div>
	
	<form action="../customer/logout">
		<button>Logout</button>
	</form>
	
	<form action="../customer/book-appointment">
		<button class="logout">Book appointment</button>
	</form>
	
	
	
	
	
	<%-- <div>
		<h3>Find your appointment status here</h3>
		
		<div>
			<form action="../customer/getAppointmentStatus">
				<input type="text" name="appointid"><button>Get Status</button>
			</form>
		</div>
		
	</div>
	<div>
			<%
				Optional<AppointmentData> appointment = (Optional<AppointmentData>) request.getAttribute("data");
			%>
				<%if(appointment!=null){ %>
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
							<td>Status of appointment</td><td><%= appointment.get().getAppointmentStatus().getStatus() %></td>
						</tr>
				  </table>
			 <%}else{ %>
				  
			  <%} %>
	</div>		 --%>
	
	<%@ include file="./footer.jsp" %>
</body>
</html>


