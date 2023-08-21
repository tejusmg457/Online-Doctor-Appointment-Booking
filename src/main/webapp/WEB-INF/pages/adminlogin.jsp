<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin login</title>
</head>
<style>

    *{
        margin: 0px;
        padding: 0px;
        font-family: 'Baloo Bhai', cursive;
        
    }
    .body{background-color: lightyellow;}
    .whole{
        position: absolute;
        top: 200px;
    }
    form{   
        align-items: center;
        border: 20px;
        border-color: white; 
    }
    .table{
        margin-left: 500px;
        padding-top: 50px;
        padding-bottom: 100px;
        padding-right: 60px;
        padding-left: 30px;
        background-color: plum;  
        border-radius: 25px;
        box-shadow: 10px 10px 10px 10px lightgray;
    }
    td{   
        padding:10px;
        font-weight: bold;
        color: blue;
        background-color: plum;       
    }
    th {
        position: absolute;
       	top: 15px;
        color: tomato;
        margin-left: 50px; 
      
    }
    #h3{
        background-color: plum;
    }
    .whole  #submit{
        position: absolute;
        padding: 10px;
        top: 160px; margin-left: 580px;
        font-weight: bolder; color: seagreen;
    }

    .whole  #forgot{
        position: absolute;
        padding: 10px;
        top: 160px; margin-left: 700px;
        font-weight: bold; color: seagreen;
    }

</style>
<body class="body">
 
  <%@ include file="./header.jsp" %>

    <div class="whole">
        <form action="admin/adminlogin" method="post">
            
                <table class="table"> 
                    <th><h3 id="h3">Admin login</h3></th>
                    <tr><td>Username:</td><td><input type="text" name="aname"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="apassword"></td></tr>
                </table>
                <button id="submit">Submit</button>
                <br>         
        </form>
        <div>
    		<form action="api/customer/showforgotpasswordpage"><button id="forgot">Forgot password</button></form>
        </div>
    
    </div>
    
    <%@ include file="./footer.jsp" %>
</body>
</html>