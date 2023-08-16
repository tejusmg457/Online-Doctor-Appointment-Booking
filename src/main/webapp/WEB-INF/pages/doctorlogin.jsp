<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor login</title>
<style>

    *{
        margin: 0px;
        padding: 0px;
        font-family: 'Baloo Bhai', cursive;
        
    }
    .body{background-color: lightyellow;}
    
    #h3{    
	        position: absolute;
		    top: 31px;
		    color: blue;
		    font-weight: bold;
		    margin-left: 138px;
		    padding: 5px;
    }
    
    .whole{
    	position: absolute;
	    margin-left: 630px;
	    top: 207px;
	    height: 320px;
	    width: 390px;
	    box-shadow: 10px 10px 10px silver;
	    border-radius: 40px;
	    background-color: darkgray;
    }
    
    table{
    	    position: absolute;
		    padding: 20px;
		    top: 60px;
		    margin-left: 25px;
    }
     #submit{
        position: absolute;
	    padding: 10px;
	    top: 185px;
	    margin-left: 80px;
	    font-weight: bolder;
	    color: seagreen;
    }

     #forgot{
        position: absolute;
	    padding: 10px;
	    top: 185px;
	    margin-left: 200px;
	    font-weight: bold;
	    color: seagreen;
    }
    td{   
        padding:10px;
        font-weight: bold;
        color: currentcolor;
    }
    #h4{ 
    	position: absolute;
	    font-weight: bold;
	    color: red;
	    text-align: center;
	    top: 250px;
	    left: 95px;
	}
</style>
</head>
<body class="body">

	<%@ include file="./header.jsp" %>
	
	<div class="whole">
	<h3 id="h3">Doctor login</h3>
        <form action="../api/doctor/doctorlogin" method="post">
                <table>
                    <tr><td>Email</td><td><input type="text" name="demail"></td></tr>
                    <tr><td>Password</td><td><input type="password"name="dpassword"></td></tr>
                </table>
                <br>
                <button id="submit">Submit</button>
        </form>
        <form action="doctor/showforgotpasswordpage"><button id="forgot" >Forgot password</button></form>
         <%
			String result =(String) request.getAttribute("msg"); 
		 %> 
		 <%
		   	 if(result!=null){ %> 
		   	 	<h4 id="h4">Invalid email or password</h4>
		<%} %>
    </div>
     <%@ include file="./footer.jsp" %>
</body>
</html>