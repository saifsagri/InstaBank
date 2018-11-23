<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<div class=outer>
<div style="color:red" >${invalid}</div><br>
<form action="intertransfer.transfer">
<!-- Payee Name: <input type="text" name="AccountNumber" value=""><br>
<br> -->

<select name="InterBeneficiary">
<c:forEach var="ben" items="${interBeneficiary}">
		<option value="${ben.interBeneficiaryId}" ${ben == param.ben ? 'selected' : ''}>${ben.getBeneficiaryName()}</option>
</c:forEach>
</select>

<!-- <label class="labelc">Amount:</label> <input type="text" name="amt" required><br>
<input type="submit" value="Submit">
</form>
<label class="labelc">Account number:</label> <input type="text" name="accountNumber" placeholder="Account Number" required><br>
<br>
<label class="labelc">Confirm account  number:</label> <input type="text" name="ConfirmAccountNumber" placeholder="Confirm Account Number" required><br>
<br>
 -->
<label class="labelc">Enter Amount:</label> <input type="text" name="amt" placeholder="Enter Amount" required><br>
<br>
<div class="clearfix">
      <a href="myprofile1.jsp"><button type="button" class="cancelbtn">Cancel</button></a>
      <button type="submit" class="registerbtn" onclick="msg()">submit</button>
    </div>
<%-- <div class="clearfix">
     <center><input type="submit" value="Submit" class="submitbtn"></center>
     <center> <button type="button" class="submitbtn">Submit</button></center>
     
    </div> --%>
</form>
</div>
</body>
</html>