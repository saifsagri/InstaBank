
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="try.css">

<style> 

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}

input[type=email] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}

</style>
<script type="text/javascript" >
   function preventBack(){window.history.forward(1);}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</head>
<body background="bg2.jpg">
<h1 style="color:#804040;">Forgot Password?</h1>
<div style="color:black">${invalid}</div><br>
 <div class="outer">
	<form action="forgotpass.do">
<label class="labelc">User ID:</label> <input type="text" name="userid" placeholder="Enter UserId" required><br>
<label class="labelc">Aadhar Card:</label><input type="text" name="aadhar" pattern="[0-9]{12}" placeholder="Enter AdharCard Number" ><br>
<label class="labelc">Email Id:</label> <input type="email" name="email" placeholder="Enter Email-ID" required><br>
	<div class="clearfix">
	<center><input type="submit" value="Continue" class="registerbtn"></center>
	<center><a href="home.jsp">  <button type="button" class="cancelbtn">Cancel</button></a></center>
</div>	
	</form>
	</div>
</body>
</html>

