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
        <form action="customer/logincustomer" method="post">
                <table>
                    <tr><td>Email</td><td><input type="text" name="cemail"></td></tr>
                    <tr><td>Password</td><td><input type="password" name="cpassword"></td></tr>
                </table>
                <br>
                <button>Submitt</button>
        </form>
    </div>
     <form action="customer/signup">
    		<h3>New User ? <Button >Click Here</Button></h3>
    </form>
</body>
</html>