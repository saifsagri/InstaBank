<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Add Account</title>
<link rel="stylesheet" type="text/css" href="try.css">
<style> 

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}
input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}

</style>
</head>
<body background="bg2.jpg">
<div class="outer">
<form action="">
 <label class="labelc"> Enter Application ID:</label>
  <input type="text" name="aid" value="" placeholder="Enter Application ID" required>
  <br>
    <br>
  
  <label class="labelc">Login:</label>
  <input type="text" name="alogin"  placeholder="Enter Adharcard Number" required>
  <br>
  <br>
   <label class="labelc">Password<label>
  <input type="password" name="apassword" placeholder="Enter DOB" required>
  <br>
    <br>
  
  <br>
  <div class="clearfix">
    <center><input type="submit" value="submit" class="submitbtn"></center>
     
    </div>
</form> 
</div>
</body>
</html>