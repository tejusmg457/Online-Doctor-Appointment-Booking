<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="in.ineuron.model.Doctor"%> <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of doctors</title>
<style>
	*{margin:0px; display:0px;}
	body{background-color: lightcyan;}
	#h3 {text-align:center; font-weight: bold; margin-top: 25px; color:blue;}
	table{ border:2px solid black; background-color: lightyellow; margin-left: 385px; margin-top: 25px; box-shadow: 10px 10px 10px silver;}
	table th{ padding:10px; color:navy; font-weight: bold;}
	table td{padding:10px}
	button{padding:5px; font-weight: bold; color:red;}
</style>
</head>
<body>
	
	<%@ include file="./header.jsp" %>
	<%
		List<Doctor> doctors = (List) request.getAttribute("doctors");
	%>
	<h3 id="h3">List of Doctors</h3>
	<table>
		<%int noOfRow = doctors.size(), rowcount=0; %>	
		<th>ID</th><th>Name</th><th>Gender</th><th>Specialist</th><th>Email Id</th><th>Password</th><th>Delete</th>
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
				<td><form action="../admin/delete-doctor" method="get"><a><button name="did" value="<%= docId %>">Delete</button></a></form></td>
			</tr>
		<% } %>		
	</table>
	
	<div>
		<%@ include file="./footer.jsp" %>
	</div></body>
</html>