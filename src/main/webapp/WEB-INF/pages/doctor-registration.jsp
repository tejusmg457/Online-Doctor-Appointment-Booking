<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page import="java.util.Optional" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
			<form action="save-doctor" method = "post"> 
			<table>
				<tr>
					<td>Doctor Name</td><td><input type="text" name="dname"></input></td>
				</tr>
				
				<tr>
					<td>Gender</td> <td><select name="dgender">
											<option>Male</option>
										    <option>Female</option>
										</select>
									</td>
				</tr>
						
				<tr>
					<td>Gender</td> <td><select name="dspecialist">
											<option>Gynocologist</option>
										    <option>Neurologist</option>
										    <option>Psychiatrist</option>
										    <option>Radiologist</option>
										    <option>Dentist</option>
										</select>
									</td>
				</tr>
				
				<tr>
					<td>Doctor Phone-No</td><td><input type="text" name="dphoneNo"></input></td>
				</tr>
				
				<tr>
					<td>Doctor email</td><td><input type="text" name="demail"></input></td>
				</tr>
				
				<tr>
					<td>Doctor Password</td><td><input type="password" name="dpassword"></input></td>
				</tr>
			</table>
			 <button>Submit</button>
			</form>
	</div>
		
	 <%
		String result =(String) request.getAttribute("msg"); 
	 %> 
	 <%
	   	 if(result!=null){ %> 
  		  <h1>Doctor registered successfully and id :: <%= result %></h1> 
	<%} %>		 
</body>
</html>