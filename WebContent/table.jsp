<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="try.css">
<style>
table, th, td {
    border: 1px solid #804040;
    border-collapse: collapse;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg2.jpg">

<%-- <% request.getSession().getAttribute("allAccounts"); %>
 --%>

<table style="color:#804040;">
  <tr>
    <th>Account Number </th>
        <th>Account type</th>
    <th>Available Balance</th>
     <!-- <th>Transaction</th> -->
    
  </tr>
  
  <c:forEach items="${allAccounts}" var="account"> 
  <tr>
    <td><c:out value="${account.getAccountNumber()}"/></td>
    <td><c:out value="${account.getAccountType()}"/></td>
    <td><c:out value="${account.getAccountBalance()}"/></td>
 
   </tr>
</c:forEach>
  
</table>

<br><br><br><br><br><br><br><br><br>
<center>
<h3>Select Account for Further Operations</h3>
<form action="selected.accounts" target="_parent">

<select name="account">
<c:forEach var="account" items="${allAccounts}">

		<option value="${account.accountNumber}" ${account == param.account ? 'selected' : ''}>${account.getAccountNumber()}</option>
</c:forEach>
</select>
<br><br>
<center><input type="submit" value="Go" class="submitbtn"></center>
</form> 
</center>
<!-- 
<form action="E-services3.jsp" target="_parent">
	<input type="submit" value="submit" >
	</form>
 -->



</body>
</html>