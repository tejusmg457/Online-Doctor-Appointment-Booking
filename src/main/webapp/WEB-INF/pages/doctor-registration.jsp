<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page import="java.util.Optional" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor registration</title>
<style>
*{
	padding: 0px; margin: 0px; 
}
body{background-color: lightyellow;}
.mydiv{    
	height: 445px;
    width: 550px;
    background-color: cadetblue;
    top: 165px;
    position: absolute;
    margin-left: 496px;
    border-radius: 65px;
}

table{
	height: 200px; width: 500px; 
	margin-left: 60px; margin-top: 48px;
}
table td{padding:10px}
option{padding:10px;}
.register{padding:10px; background-color: lightcyan; font-weight: bold;     margin-left: 225px; margin-top: 10px;}
#h1{ font-weight: bold; color: blue; text-align: center; margin-top: 25px;}
#result{ 
	position: absolute;
    top: 535px;
    padding: 10px;
    margin-left: 545px;
    color: floralwhite;
    font-weight: bold;}
</style>
</head>
<body>
	<%@ include file="./header.jsp" %>
	<h1 id="h1">Doctor registration</h1>
	<div class="mydiv">
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
					<td>Specilist</td> <td><select name="dspecialist">
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
			 <button class="register">register</button>
			</form>
	</div>
		
	 <%
		String result =(String) request.getAttribute("msg"); 
	 %> 
	 <%
	   	 if(result!=null){ %> 
  		  <h4 id="result">Doctor registered successfully and id <%= result %> for reference</h4> 
	<%} %>	
	
	<%@ include file="./footer.jsp" %>	 
</body>
</html>