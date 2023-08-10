<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="getPassword" method="post">
			<table>
				<tr>
					<td>Doctor ID</td><td><input name="did" type="text"/></td>
				</tr>
				<tr>
					<td>Mail id</td><td><input name="demail" type="email"/></td>
				</tr>
			</table>
			<button>Get password</button>
		</form>
		<%
		String result =(String) request.getAttribute("password"); 
		String error =(String) request.getAttribute("error"); 
	 	%> 
	 	<%
		   	 if(result!=null){ %> 
	  		 <h1>Your password is <%= result %></h1> 
	  		  if(error!=null){ %> 
	  		 <h1>Invalid Customer Id and mail </h1> 
		<%} %>		
	</div>
</body>
</html>