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

<div class="topnav">
  <a  href=intraadd.jsp>Add</a>
  
  <a href="intradeleteben.jsp">Delete</a>
    <a class="active" href="intraviewallben.jsp">View all</a>
  
  
  
  
  
  
</div>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Intra beneficiary</title>
<style>
table, th, td{
    border: 1px solid #804040;
    border-collapse: collapse;
}
</style>
</head>
<body background="bg2.jpg">





<center><h1 style="color:#804040;">IntraBank Beneficiaries</h1></center>
<table style="color:#804040;">
  <tr>
    <th>Beneficiary Account Number</th>
        <th>Name</th>
    <th>IFSC</th>
     <!-- <th>Transaction</th> -->
    
  </tr>
<c:forEach items="${intraBeneficiary}" var="ben"> 
  <tr>
    <td><c:out value="${ben.getBenAccountId()}"/></td>
    <td><c:out value="${ben.getBeneficiaryName()}"/></td>
    <td><c:out value="${ben.getIfsc()}"/></td>
   </tr>
</c:forEach>
  </table>
  
</body>
</html>