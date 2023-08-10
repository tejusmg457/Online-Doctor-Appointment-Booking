<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ page import="java.util.Optional" %><%@ page import="in.ineuron.model.AppointmentData" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% int noOfAppointmentsForToday =  (int) request.getAttribute("noOfAppointmentsForToday"); %>
	<% int noOfCustomers =  (int) request.getAttribute("noOfCustomers"); %>
	<% int noOfDoctors =  (int) request.getAttribute("noOfDoctors"); %>
	
	<h3>No of appointments for today is :: <%= noOfAppointmentsForToday %></h3>
	<h3>No of Customers :: <%= noOfCustomers %></h3>
	<h3>No of Doctors :: <%= noOfDoctors %></h3>
	
	<div>
	<form action="../admin/doctor-registration">
		<button>Doctor registration</button>
	</form>
	 <%
		String result =(String) request.getAttribute("msg"); 
	 %> 
	 <%
	   	 if(result!=null){ %> 
  		  <h1>Doctor registered successfully and id :: <%= result %></h1> 
	<%} %>
	</div>
	
	<form action="../admin/listofdoctors">
		<button>List of Doctors</button>
	</form>
	
	
	<div>
		<h3>Get appointment List</h3>
		<form action="../admin/listofappointments">
			<table>
				<tr>
					<td>From</td><td><input type="date" name="fdate"></input></td>
				</tr>
				<tr>
					<td>To</td><td><input type="date" name="tdate"></input></td>
				</tr>	
			</table>
			<button>get Appointment list</button>
		</form>
	</div>
	
	<div>
		<h3>Delete customer</h3>
		<form action="../admin/delete-customer">
			<input type="text" name="cid"><button>Delete</button>
		</form>
		<%
		String deleteResult =(String) request.getAttribute("msg"); 
		 %> 
	 	<%
	   	 	if(deleteResult!=null){ %> 
  		  	<h1><%= deleteResult %></h1> 
		<%} %>
	</div>
	
	<div>
		<h3>track appointment status</h3>
		<form action="../admin/track-appointment">
			<input type="text" name="apointid"><button>Get Status</button>
		</form>
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
	</div>
	
	<form action="../admin/logout">
		<button>Logout</button>
	</form>
	
	
</body>
</html>