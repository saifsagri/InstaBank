<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="myprofile.css">
  <link rel="stylesheet" type="text/css" href="try.css">

<div class="topnav">
  <a  href=interadd.jsp>Add</a>
 
  <a class="active" href="interdeleteben.jsp">Delete</a>
    <a  href="interviewallben.jsp">View all</a>
  
  
</div>
<h1 style="color:#804040;">DELETE BENEFICARY</h1>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg2.jpg">
<form action="">
<input type="radio" name="bene" value="b1"><font size="5" color="#804040;" >Beneficiary1</font><br>
  <input type="radio" name="bene" value="b2" ><font size="5" color="#804040;">Beneficiary2</font><br>
  
  
  
  
<div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="registerbtn">Delete</button>
    </div>
</form>
</body>
</html>