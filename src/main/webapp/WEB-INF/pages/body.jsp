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
        
        background-color: sandybrown;
       
    }
    .area{margin-top:85px;}
    .area .left{
        display: inline-block;
    }
    .area .right{
        display: inline-block;
    }
    
    .area .left .para{
        height: 300px;
        width: 550px;
        margin-right: 200px;
        margin-left: 100px;
        padding-top: 157px; 
        display: inline-block;
    }
    li{
        color: #0F1860;  
    }
    .area .left h4{
        margin-right: 300px;
        text-align: right;
    }
    #quote{
        color: white;
        font-weight: bold;
        text-align: center;
    }
    #auth{
        text-align: right;
        margin-right: 300px;
        color: #42600F;
    }

    .area .right img{
        position: absolute;
        height: 300px;
        width: 500px;
        top: 150px;
        margin-left: 50px;
        border-radius: 25px;
    }

</style>
<body>
  <div class="area">
        <div class="left">
           <h3>
                <ul class="para">
                    <li>Our cutting-edge doctor appointment booking website seamlessly bridges the gap between medical professionals and patients, ensuring a streamlined and efficient healthcare experience for all.</li>
                    <li>Patients benefit from easy-to-navigate features that empower them to search for specialized practitioners, view real-time availability, and conveniently book appointments at their preferred Date.</li>
                    <li>Our platform prioritizes patient privacy and data security, maintaining the utmost confidentiality of medical records and personal information.</li>
                </ul>
           </h3>  
         </div>

        <div class="right">
           <img src="https://images.pexels.com/photos/5998450/pexels-photo-5998450.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" >
        </div>
    </div>
    <br><br><h3 id="quote">“It is health that is the real wealth, and not pieces of gold and silver”</h3>
    <h4 id="auth">-Mahatma Gandhi</h4>
</body>
</html>