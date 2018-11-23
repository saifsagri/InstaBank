<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function msg() {
    alert("Confirm Transfer..?");
}
</script>
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
</head>
<body background="bg2.jpg">

<div class="outer">
<div style="color:red">${invalid}</div><br>
<form action=quicktransfer.transfer>
<label class="labelc">Account Number:</label> <input type="text" name="payeeAccountNumber" required><br>
<label class="labelc">Amount:</label> <input type="text" name="amt" required><br>

<div class="clearfix">
     <a href="myprofile1.jsp"> <button type="button" class="cancelbtn">Cancel</button></a>
      <button type="submit" class="registerbtn" onclick="msg()">Submit</button>
   
     
    </div>
</form>
</div>
</body>
</html>