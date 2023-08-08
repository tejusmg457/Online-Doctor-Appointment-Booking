<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String demail = (String) request.getAttribute("demail"); %>
	<h1>doctor dashboard</h1>
	<h3>Welcome Doctor <%= demail %></h3>
	<% session.setAttribute("demail", demail); %>
	
	<div>
		<form action="listOfPendingAppointments" method="get"><button name="demail" value="<%= demail %>">List of Appointments</button></form>
	</div>
	
	<div>
		<form action="listOfAppointmentsToday" ><button name="demail" value="<%= demail %>">Today appointment List</button></form>
	</div>
	
	<div>
		<h3>Complete appointment</h3>
		<form action="complete-appointment" method="post">
			<input type="text" name="appointid"><button>Completed</button>
		</form>
	</div>
	<div>
		 <%
			String info =(String) request.getAttribute("info"); 
		 %> 
		 <%
	   	 	if(info!=null){ %> 
  		 	 	<h1><%= info %> </h1> 
		<%} %>	
	</div>
</body>
</html>