<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor login</title>
</head>
<body>
	<div>
        <form action="doctorlogin" method="post">
                <table>
                    <tr><td>Email</td><td><input type="text" name="demail"></td></tr>
                    <tr><td>Password</td><td><input type="password"name="dpassword"></td></tr>
                </table>
                <br>
                <button>Submit</button>
        </form>
    </div>
     <div>
    
    		<form action="showforgotpasswordpage"><button>Forgot password</button></form>
    </div>
</body>
</html>