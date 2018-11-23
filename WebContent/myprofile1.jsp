<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
  <link rel="stylesheet" href="myprofile.css">
  <link rel="stylesheet" href="try.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg2.jpg">
<div class="topnav">
  <a class="active" href="#mp">My Profile</a>
  <a href="E-services2.jsp">E-Services</a>
  <a href="SelectAccount.jsp">Fund Transfer</a>
  <a href="logout.jsp">Logout</a>

</div>

<div style="padding-bottom: 10px; padding-top: 5px; text-align: centre; padding-left: 300px;">

<jsp:useBean id="customerObject" class="bean.Customer" scope="session"/>
<br><br><br><br>
  <label><b>Login ID/User ID : </b></label><jsp:getProperty property="customer_id" name="customerObject"/><br><br>
  <label><b>Name : </b></label><jsp:getProperty property="customer_name" name="customerObject"/><br><br>
  
   <label><b>Address : </b><br></label><jsp:getProperty property="address" name="customerObject"/><br><br>
 <%--   <label>Street-Address:</label><br><jsp:getProperty property="address.street_address" name="customer"/>
    <label>City:</label><br><jsp:getProperty property="address.city" name="customer"/>
  <label>State:</label><br><jsp:getProperty property="address.state" name="customer"/>
  <label>Country:</label><br><jsp:getProperty property="address.country" name="customer"/>
   <label>Zipcode:</label><br><jsp:getProperty property="address.zipcode" name="customer"/> --%>
  <label><b>Email : </b></label><jsp:getProperty property="email" name="customerObject"/><br><br>
  <label><b>Mobile : </b></label><jsp:getProperty property="phone" name="customerObject"/><br><br>
  <label><b>DOB : </b></label><jsp:getProperty property="dob" name="customerObject"/><br><br>
    <label><b>AADHAR : </b></label><jsp:getProperty property="aadhar" name="customerObject"/><br><br>
      <label><b>PAN: </b></label><jsp:getProperty property="pancard" name="customerObject"/><br><br>
      
   <br>
<form action="changecredentials.jsp">
<center><input type="submit" value="Change Credentials" class="submitbtn" ></form></center>

</body>
</html>