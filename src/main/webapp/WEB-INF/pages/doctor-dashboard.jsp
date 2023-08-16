<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor dashboard</title>
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/doctordashboard.css">
</head>
<body>

	<%@ include file="./header.jsp" %>
	
	
	<%String demail = (String) request.getAttribute("demail");
	String dname = (String) request.getAttribute("dname"); 
	session.setAttribute("demail", demail); 
	session.setAttribute("dname", dname); 
	
	int hour = LocalDateTime.now().getHour();
	String wish=null;
	if(hour<12)
		wish="Good morning!";
	else if(hour<16)
		wish="Good afternoon!";
	else
		wish="Good evening";
	%>
	<h2 id="ribbon">Doctor Dashboard</h2>
	
	<div class="wish">
		<h3 id="wishMsg"><%= wish %></h3>
		<h3 id="name">Docter. <%= dname.toUpperCase() %></h3>
	</div>
	
	<form action="logout">
		<button class="logout">Logout</button>
	</form>
	
	<div>
		<form action="listOfPendingAppointments" method="get"><button class="appointmentList" name="demail" value="<%= demail %>"><h3>List of Appointments</h3></button></form>
	</div>
	
	<div>
		<form action="listOfAppointmentsToday" ><button class="appointmentToday" name="demail" value="<%= demail %>">Today's appointment List</button></form>
	</div>
	
	<div>
		<form action="Appointment-history">
			<button class="appointmenthistory" name="demail" value="<%= demail %>">Appointment History</button>
		</form>
	</div>
	
	<div class="completemain">
		<h3 id="h3">Complete appointment</h3>
		<form action="complete-appointment" method="post">
			<input type="text" placeholder="Enter Appointment Id" name="appointid"><button class="completebutton">Complete</button>
		</form>
	
		 <%
			String info =(String) request.getAttribute("info"); 
		 %> 
		 <%
	   	 	if(info!=null){ %> 
  		 	 	<h4 id="msg"><%= info %> </h4> 
		<%} %>	
	</div>
	<%@ include file="./footer.jsp" %>
</body>
</html>