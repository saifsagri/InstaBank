<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" >
   function preventBack(){window.history.forward(1);}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
  <link rel="stylesheet" href="myprofile.css">
<link rel="stylesheet" href="try.css">
<div class="topnav">
  <a  href="intraadd.jsp">Add</a>
  
  <a class="active" href="intradeleteben.jsp">Delete</a>
    <a href="intraviewallben.jsp">View all</a>
  
  
</div>
<h1 color="#804040;">DELETE BENEFICARY</h1>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg2.jpg">
<form action="delete.ben">
<!-- Payee Name: <input type="text" name="AccountNumber" value=""><br>
<br> -->

<select name="ben">
<c:forEach var="ben" items="${intraBeneficiary}">

		<option value="${ben.intraBeneficiaryId}" ${ben == param.ben ? 'selected' : ''}>${ben.getBeneficiaryName()}</option>
</c:forEach>
</select>
<div class="clearfix">
      <a href="myprofile1.jsp"><button type="button" class="cancelbtn">Cancel</button></a>
      <button type="submit" class="registerbtn">Submit</button>
    </div>
<%-- 
<center><input type="submit" value="Submit" class="submitbtn"></center> --%>
</form>
</body>
</html>