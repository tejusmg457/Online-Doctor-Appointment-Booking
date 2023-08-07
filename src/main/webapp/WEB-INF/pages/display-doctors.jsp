<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.Doctor"%> <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of doctors</title>
</head>
<body>
	<%
		List<Doctor> doctors = (List) request.getAttribute("doctors");
	%>
	<table>
		<%int noOfRow = doctors.size(), rowcount=0; %>	
		<% for(rowcount=0; rowcount <noOfRow; rowcount++){%>
			<tr>
				<% Doctor doctor = (Doctor) doctors.get(rowcount); %>
				<%String docId = doctor.getDid();  %>
				<td><%= docId %></td>
				<td><%= doctor.getDname() %></td>
				<td><%= doctor.getDgender() %></td>
				<td><%= doctor.getDspecialist() %></td>
				<td><%= doctor.getDemail()%></td>
				<td><%= doctor.getDpassword() %></td>
				<td><form action="../admin/delete-doctor" method="get"><button name="did" value="<%= docId %>">Delete</button></form></td>
			</tr>
		<% } %>		
	</table>
</body>
</html>