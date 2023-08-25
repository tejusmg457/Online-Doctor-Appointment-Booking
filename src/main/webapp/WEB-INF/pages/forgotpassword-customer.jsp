<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot password?</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/forgotpassword.css">
</head>
<body>

	<%@ include file="./header.jsp" %>
	
	<div class="Section">
		<form action="getPassword" method="post">
			<table>
				<tr>
					<td>Customer ID</td><td><input name="cid" type="text"/></td>
				</tr>
				<tr>
					<td>Mail id</td><td><input name="cemail" type="email"/></td>
				</tr>
			</table>
			<button class="button">Get password</button>
		</form>
		<%
		String result =(String) request.getAttribute("msg"); 
	 	%> 
	 	<%
		   	 if(result!=null){ %> 
	  		 <h3 id="result"><%= result %></h3> 
	  		<% } %>
	</div>
	
	<%@ include file="./footer.jsp" %>
	
</body>
</html>