<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style> 

input[type=button] {
    padding: 14px 20px;
    background-color: #804040;
    color: white;
    font-size: 20px;
}
table, th, td{
    border: 1px solid #804040;
    border-collapse: collapse;
}

</style>

<script type="text/javascript">

function printDiv(divName) {

 var printContents = document.getElementById(divName).innerHTML;
 w=window.open();
 w.document.write(printContents);
 w.print();
 w.close();
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
</head>
<body background="bg2.jpg">
<h2 style="color:#804040;">Your latest 10 transaction details are as follows...</h2>

<div id="print-content">

<table style="color:#804040;">
  <tr>
   <th>Transaction Id</th>
    <th>AMOUNT</th>
    <th>DESCRIPTION</th>
    <th>TRANSACTIONDATE</th>
     <!-- <th>Transaction</th> -->
    
  </tr>
  
  <c:forEach items="${transactions}" var="t" begin="0" end="9"> 
  <tr>
    <td><c:out value="${t.getTransactionId()}"/></td>
    <td><c:out value="${t.getAmount()}"/></td>
    <td><c:out value="${t.getDescription()}"/></td>
    <td><c:out value="${t.getTransactionDate()}"/></td>
 
   </tr>
</c:forEach>
  
</table>
</div>

<form>
<h4><center>Print your account statement</center></h4>
  <center><input type="button" onclick="printDiv('print-content')" value="Download Pdf"/></center>
</form>


<form><!-- 
<input  onclick="window.location.href='E-services2.jsp'" target="_parent" type="submit" value="back"></a> -->

</form>

</body>
</html>