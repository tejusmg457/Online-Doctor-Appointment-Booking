<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="customer/save-customer" method = "post"> 
			<table>
				<tr>
					<td>Name</td><td><input type="text" name="cname"></input></td>
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
			 <button>Submitt</button>
		</form>
	</div>
</body>
</html>