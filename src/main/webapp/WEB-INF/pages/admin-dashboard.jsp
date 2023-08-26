<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ page import="java.util.Optional" %><%@ page import="in.ineuron.model.AppointmentData" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin dashboard</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admindashboard.css">
</head>
<body>
	
	<%@ include file="./header.jsp" %>
	
	<h2>Admin Dashboard</h2>
	<% int noOfAppointmentsForToday =  (int) session.getAttribute("noOfAppointmentsForToday"); %>
	<% int noOfCustomers =  (int) session.getAttribute("noOfCustomers"); %>
	<% int noOfDoctors =  (int) session.getAttribute("noOfDoctors"); %>
	
	<div class="appointment">
		<h3>Appointments today <br><hr><h1> <%= noOfAppointmentsForToday %></h1> </h3>
	</div>
	
	<div class="customer">
		<h3>Customers count<br><hr><h1> <%= noOfCustomers %></h1> </h3>
	</div>
	
	<div class="Doctors">
		<h3>Doctors count<br><hr><h1> <%= noOfDoctors %></h1> </h3>
	</div>
	
	<div class="logout">
		<form action="../admin/logout">
		<button>Logout</button>
	</form>
	</div>
	
	<div class="options">
				<a href="../admin/doctor-registration"><button class="docreg">Doctor registration</button></a>
	</div>
	
	<div>
		<form action="../admin/listofdoctors">
			<button class="doctorList">List of Doctors</button>
		</form>
	</div>
	
	<div class="appointList">
		<h3>Get appointments List</h3>
		<form action="../admin/listofappointments">
			<table class="appointListTable">
				<tr>
					<td>From</td><td><input type="date" name="fdate"></input></td>
				</tr>
				<tr>
					<td>To</td><td><input type="date" name="tdate"></input></td>
				</tr>	
			</table>
			<button class="listdocsubbutton">Get List</button>
		</form>
	</div>
	
	<div class="deletecustomer">
		<h3>Delete customer</h3>
		<form action="../admin/delete-customer" class="form">
			<input type="text" name="cid" placeholder="Enter customer Id"><button>Delete</button>
		</form>
		<%
			String deleteResult =(String) request.getAttribute("msg"); 
		 %> 
	 	<%
	   	 	if(deleteResult!=null){ %> 
  		  	<h4 style="margin-top: 5px;"><%= deleteResult %></h4> 
		<%} %>
	</div>
	
	<div class="track">
		<h3>track appointment status</h3>
		<form action="../admin/track-appointment" class="form">
			<input type="text" name="apointid" placeholder="Enter appointment Id"><button>Get Status</button>
		</form>
	</div>
	
	<%@ include file="./footer.jsp" %>
</body>
</html>