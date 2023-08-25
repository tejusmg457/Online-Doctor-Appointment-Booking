<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
</head>
<body>
    
    <%@ include file="./header.jsp" %>
    
    <div class="area" style="background-color: sandybrown;">
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
        <br><h3 id="quote">It is health that is the real wealth, and not pieces of gold and silver</h3>
   		<h4 id="auth">-Mahatma Gandhi</h4><br>
    </div>
    
    <%@ include file="./footer.jsp" %>
    
</body>
</html>