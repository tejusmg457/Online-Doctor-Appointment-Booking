<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Docter login</title>
</head>
<body>
	<div>
        <form action="doctor/doctorlogin" method="post">
                <table>
                    <tr><td>Docter ID</td><td><input type="text" name="did"></td></tr>
                    <tr><td>Password</td><td><input type="password"name="dpassword"></td></tr>
                </table>
                <br>
                <button>Submitt</button>
        </form>
    </div>
</body>
</html>