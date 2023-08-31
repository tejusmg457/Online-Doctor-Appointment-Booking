<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book appointment</title>
</head>
<style>

*{ margin: 0px; padding:0px;}
body{ background-color: pink;}
.div{ position: absolute; top: 100px; left: 550px;}
.table{ margin-left: 100px; margin-top: 15px;}
td{ 
	padding: 10px;
    color: black;
    font-size: 18px;
    font-weight: bold;}
select{ padding: 4px;}
.button{     padding: 8px; margin-left: 225px; margin-top: 10px; font-weight: bold;}
#msg{ color: navy; font-weight: bolder; position: absolute;top: 510px; left: 510px; }
#h3{ text-align: center; margin-top: 15px; color: navy; font-weight: bold;}

</style>
<title>Appointment book</title>
</head>
<body>

	<%@ include file="./header.jsp" %>
	
	<% String[] docNames = (String[]) session.getAttribute("docNames");
	String[] docSpecialists = (String[]) session.getAttribute("docSpecialists"); 
	%>

	<div class="div">
		<h3 id="h3">Book your appointment </h3>
		<form action="../customer/BookAppointment" method="post">
			<table class="table">
				<tr>
					<td>Patient Name</td><td><input type="text" name="pname"></input></td>
				</tr>
				
				<tr>
					<td>Patient age</td><td><input type="text" name="page"></input></td>
				</tr>
				
				<tr>
					<td>Appointment date</td><td><input type="date" name="adate" min=<%= LocalDate.now() %>></input></td>
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
			<button class="button" >submit</button>
		</form>
	</div>
		
	 <%
		String result =(String) request.getAttribute("msg"); 
	 %> 
	 <%
	   	 if(result!=null){ %> 
  		  <h3 id="msg" style="text-align:Center;"><%= result %> </h3> 
	<%} %>		
	
	<%@ include file="./footer.jsp" %>
</body>
</html>