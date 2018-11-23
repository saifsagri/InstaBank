<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="try.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg2.jpg">
<center>

<!-- <div class="dropdown"> -->

<br><br>
<h1 style="color:#804040;">Select Account for Fund Transfer</h1>
<br><br>
<form action="fundTransferAccount.accounts" target="_parent">
<!--  <div id="myDropdown" class="dropdown-content"> -->
<select name="account">
<c:forEach var="account" items="${allAccounts}">
		<option value="${account.accountNumber}" ${account == param.account ? 'selected' : ''}>${account.getAccountNumber()}</option>
</c:forEach>
</select>
<!-- </div> -->
</center>
<br><br>
<center><input type="submit" value="Go For Transfer" class="submitbtn" ></center>

<!-- </div> -->
</form> 
<br><br>
<center><a href="myprofile1.jsp"> <button type="button" class="submitbtn">Go Back To MY Profile</button></a></center></center></body>
</html>