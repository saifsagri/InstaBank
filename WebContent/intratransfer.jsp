<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function msg() {
    alert("Confirm Transfer..?");
}
</script>
<link rel="stylesheet" type="text/css" href="try.css">
<title>Insert title here</title>
<style> 

input[type=text] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}
</style>
</head>
<body background="bg2.jpg">
<center>
<div style="color:red" >${invalid}</div><br>
<form action="intratransfer.transfer">
<!-- Payee Name: <input type="text" name="AccountNumber" value=""><br>
<br> -->
<div class="dropdown">
<select name="IntraBeneficiary">
<c:forEach var="ben" items="${intraBeneficiary}">
		<option value="${ben.intraBeneficiaryId}" ${ben == param.ben ? 'selected' : ''}>${ben.getBeneficiaryName()}</option>
</c:forEach>
</select>
</div>
<!--  Payee name : <select name="cars">
    <option value=""></option>
    <option value=""></option>
    <option value=""></option>
    <option value=""></option>
  </select>
  <br><br>
Amount: <input type="text" name="ConfirmAccountNumber" value=""><br>
<br>
Accoount type: <input type="text" name="ConfirmAccountNumber" value=""><br>
<br> -->
<br><br>
<label class="labelc">Amount:</label> <input type="text" name="amt" required><br>
<br><br>
<div class="clearfix">
      <a href="myprofile1.jsp"><button type="button" class="cancelbtn">Cancel</button></a>
      <button type="submit" class="registerbtn" onclick="msg()">Submit</button>
    </div>
<%-- <center><input type="submit" value="Submit" class="submitbtn"></center>	 --%>
</form>
</center>
<br><br><br>
<center><a href="myprofile1.jsp">Click here to go back to Your Profile</a></center>
</body>
</html>