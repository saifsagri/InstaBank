<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
 <script type="text/javascript" >
   function preventBack(){window.history.forward(1);}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
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
<br>
<br>
<br>
<br>
<div class="outer">

<div style="color:red" >${invalid}</div><br>
<form method=post action=login.do>
<label class="labelc">User ID:</label> <input type="text" name="login" required><br>
<label class="labelc">Password:</label> <input type="password" name="password" required><br>

<div class="clearfix">
     <center> <button type="submit" class="submitbtn">Login</button></center>
    </div>

<a href="forgotpass.jsp">Forgot Password..?</a>
</form>
</div>
</body>
</html>