<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
    <style>
        *{
            font-family: 'Baloo Bhai', cursive;
            margin:0px;
            padding:0px;
        }
        header{
            background-color: #5d6a81 !important;
            width: 100% !important;
            height: 85px !important;
        }
        .left h3{
            color: greenyellow;
            font-weight: bold;
            font-size: 25px;
            display: inline-block;
            margin-top: -4px;
            padding: 10px;
            margin-left: 110px;
        }
        .left img{
            position: absolute;
            width: 80px;
            height: 50px;
            margin-top: 15px;
            margin-left: 20px;
        }

        .right{
            display:block;
            height:70px;
            position: absolute;
            top: 25px;
            left: 500px;      
        }
        .right ul li {
            display: inline-block;
            margin-left: 60px;    
            margin-top: -4px;
        }
        
        a{
            text-decoration: solid; 
            color:springgreen;
            font-size: 25px;
            font-weight: bold;
            padding:10px;
            margin-top: 30px;
        }
       
    </style>
<body>
	 <header style="background-color: #5d6a81 !important; width: 100%; height: 85px;">
        <div class="left">
            <img src="https://images.pexels.com/photos/4386466/pexels-photo-4386466.jpeg?auto=compress&cs=tinysrgb&w=600" alt="">
            <h3>Angel-wood healthcare <br>Services</h3>
        </div>

        <div class="right">
            <ul id="pages">
                <li><a href="/book-your-appointment/">Home</a></li>
                <li><a href="/book-your-appointment/adminlogin">Admin</a></li>
                <li><a href="/book-your-appointment/doctorlogin">Doctor</a></li>
                <li><a href="/book-your-appointment/customerlogin">Customer</a></li>
            </ul>
        </div>
    </header>
</body>
</html>