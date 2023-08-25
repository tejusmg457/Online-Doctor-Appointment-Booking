<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer registration</title>
<style type="text/css">
	*{ margin:0px; padding:0px;}
	
	body{ background-color: lightyellow;}
	
	.select{ height: 440px;
	    width: 440px;
	    box-shadow: 10px 10px 10px silver;
	    background-color: lightcyan;
	    margin-left: 550px;
	    margin-top: -20px;
	    border-radius: 30px;
	    }
	table{
		margin-left: 50px;
		margin-top: 60px
	}
	td{
		margin-top: 60px; font-weight: bold; padding: 10px; 
	}
	.submit{    padding: 8px;
    font-weight: bold;
    margin-top: 15px;
    margin-left: 200px;}
	
	#msg{text-align: center;
    font-weight: bold;
    color: darkgreen;
    padding-left: 45px;
    padding-right: 45px;
    margin-top: 20px;}
    
    #td1{ padding-top: 25px;}
    
    #h2{ text-align:center; color:navy; font-weight: bold;  margin-top: 45px;}
    
    
</style>
</head>
<body>

 <%@ include file="./header.jsp" %>
 
 <h2 id="h2">New Patients can register here!</h2>
 
	<div class="select">
		<form action="save-customer" method = "post"> 
			<table>
				<tr>
					<td id="td1">Name</td><td><input type="text" name="cname"></input></td>
				</tr>
				
				<tr>
					<td>Age</td><td><input type="text" name="cage"></input></td>
				</tr>
				
				<tr>
					<td>Gender</td> <td><select name="cgender">
											<option>Male</option>
										    <option>Female</option>
										</select>
									</td>
				</tr>
				
				<tr>
					<td>Phone-No</td><td><input type="text" name="cphoneNo"></input></td>
				</tr>
				
				<tr>
					<td>Email</td><td><input type="text" name="cemail"></input></td>
				</tr>
				
				<tr>
					<td>Password</td><td><input type="password" name="cpassword"></input></td>
				</tr>
			</table>
			 <button class="submit">Submitt</button>
		</form>
		<%
		String result =(String) request.getAttribute("msg"); 
		 %> 
		 <%
		   	 if(result!=null){ %> 
	  		  <h3 id="msg">Customer registration successfull and id <%= result %> for your reference</h3> 
		<%} %>	
	</div>
	
	<%@ include file="./footer.jsp" %>
	
</body>
</html>