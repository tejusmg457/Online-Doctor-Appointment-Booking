<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<title>Insert title here</title>
</head>
<body>
	
	<h3>Book your appointment </h3>
	<div>
		<form:form action="../customer/BookAppointment" method="post" modelAttribute="doctor" >
			<table>
				<tr>
					<td>Patient Name</td><td><form:input type="text" path="pname"/></td>
				</tr>
				
				<tr>
					<td>Patient age</td><td><form:input type="text" path="page"/></td>
				</tr>
				
				<tr>
					<td>Appointment date</td><td><form:input type="date" path="adate"/></td>
				</tr>
				
				<tr>
					<td>Symptoms</td><td><form:input type="text" path="psymptoms"/></td>
				</tr>
				
				<tr>
					<td>Doctor</td> <td><form:select path="dname">
											<form:options items="${ doctors }"/>
										</form:select>
									</td>
				</tr>
				
				<tr>
					<td>Doctor specialist</td> <td><form:select path="dspecialist">
											<form:options items="${ doctorSpecialist }"/>
										</form:select>
									</td>
				</tr>
			</table>
			<button>submit</button>
		</form:form>
	</div>
		
	 <%
		String result =(String) request.getAttribute("msg"); 
	 %> 
	 <%
	   	 if(result!=null){ %> 
  		  <h1>Appointment booked successfully and id <%= result %> for your reference</h1> 
	<%} %>		
</body>
</html>