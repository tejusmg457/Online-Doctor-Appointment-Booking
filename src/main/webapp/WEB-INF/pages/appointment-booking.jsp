<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<title>Insert title here</title>
</head>
<body>
	<% String[] docNames = (String[]) request.getAttribute("docNames");%>
	<% String[] docSpecialists = (String[]) request.getAttribute("docSpecialists"); %>
	<h3>Book your appointment </h3>
	<div>
		<form action="../customer/BookAppointment" method="post">
			<table>
				<tr>
					<td>Patient Name</td><td><input type="text" name="pname"></input></td>
				</tr>
				
				<tr>
					<td>Patient age</td><td><input type="text" name="page"></input></td>
				</tr>
				
				<tr>
					<td>Appointment date</td><td><input type="date" name="adate"></input></td>
				</tr>
				
				<tr>
					<td>Symptoms</td><td><input type="text" name="psymptoms"></input></td>
				</tr>
				
				<tr>
					<td>Doctor</td> <td><select name="dname">
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
			</table>
			<button>submit</button>
		</form>
	</div>
		
	 <%
		String result =(String) request.getAttribute("msg"); 
	 %> 
	 <%
	   	 if(result!=null){ %> 
  		  <h1><%= result %></h1> 
	<%} %>		
</body>
</html>