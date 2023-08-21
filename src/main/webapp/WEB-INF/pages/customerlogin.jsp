<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer login</title>
<style type="text/css">

	*{margin:0px; padding:0px;}
	body{background-color: lightyellow;}
	
	.login{position: absolute;
    background-color: grey;
    left: 610px;
    top: 200px;
    height: 350px;
    width: 410px;
    box-shadow: 10px 10px 10px silver;
    border-radius: 50px;}
    
    table{margin-left: 40px; margin-top: 15px}
	td{padding:10px; color: aqua; font-weight: bold;}
	
	.submit{padding: 8px;
    font-weight: bold;
    position: absolute;
    top: 175px;
    left: 85px;}
    
	.forgot{padding: 8px;
    font-weight: bold;
    position: absolute;
    top: 175px;
    left: 200px;}
    
	.register{padding:20px; font-weight: bold; text-decoration: none; color:greenyellow;}
	
	.user{ padding: 20px;
    font-weight: bold;
    margin-top: 20px;
    margin-left: 32px;
    color: navy;}

	#msg{padding: 5px; color:aliceblue; margin-top: 15px; text-align: center; font-weight: bolder;}
	
	#invalid{color:red; text-align: center; font-weight: bolder;}

</style>
</head>
<body>
	  <%@ include file="./header.jsp" %>
	 <div class="login">
	 	<h2 id="msg">customer login</h2>
        <form action="../api/customer/logincustomer" method="post">
                <table>
                    <tr><td>Email</td><td><input type="text" name="cemail"></td></tr>
                    <tr><td>Password</td><td><input type="password" name="cpassword"></td></tr>
                </table>
                <br>
                <button class="submit">Submit</button>
        </form>
        <form action="../customer/showforgotpasswordpage"><button class="forgot">Forgot password</button></form>
    
     	<form action="customer/signup">
    		<h3 class="user">New User ? <a href="../customer/signup" class="register">Register here</a></h3>
   		 </form>
   		 <%
			String result =(String) request.getAttribute("msg"); 
		 %> 
		 <%
		   	 if(result!=null){ %> 
		   	 	 <h3 id="invalid"><%= result %></h3>   
		<%} %>
   		   
    </div>
    
    		
    <%@ include file="./footer.jsp" %>
</body>
</html>