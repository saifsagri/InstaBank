<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" >
   function preventBack(){window.history.forward(1);}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
  <link rel="stylesheet" href="myprofile.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<div class="topnav">
  <a class="active" href=intraadd.jsp">Add</a>

  <a href="intradeleteben.jsp">Delete</a>
    <a href="intraviewallben.jsp">View all</a>
  
  
</div>
<title>Intra</title>
<link rel="stylesheet" type="text/css" href="try.css">
<style> 

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}

</style>
<h1 style="color:#804040;"> ADD INTRABANK BENEFICIARY</h1>

</head>
<body background="bg2.jpg">
<div class="outer">
<center><div style="color:blue">${valid}</div><br></center>
<center><div style="color:red">${invalid}</div><br></center>
<form action="intradd.ben">
<label class="labelc">Name:</label><input type="text" name="beneficiaryName" placeholder="Name" required><br>
<br>
 <label><div class="form-group required">

									<script type="text/javascript">
										var check = function() {
											if (document
													.getElementById('accountnumber').value == document
													.getElementById('confirmaccountnumber').value) {
												document
														.getElementById('message').style.color = 'green';
												document
														.getElementById('message').innerHTML = 'matching';
											} else {
												document
														.getElementById('message').style.color = 'red';
												document
														.getElementById('message').innerHTML = 'not matching';
											}
										}
									</script>


									<label class="labelc">Enter Account Number </label> <input class="form-control"
										name="benAccountId" id="accountnumber" type="text"
										onkeyup='check();' placeholder="Enter Account Number" pattern="[0-9]{8}" required />
									
									<br> <br>
									<label class="labelc">Confirm Account Number</label><input
										class="form-control" type="text" name="confirmaccountnumber"
										id="confirmaccountnumber" onkeyup='check();' placeholder="Confirm Account Number" required /> <span
										id='message'></span>
									
								</div>
<br>
<label class="labelc">IFSC:</label><input type="text" name="ifsc" placeholder="Enter IFSC-code" required><br>

<div class="clearfix">
      
      <center><button type="submit" class="submitbtn">Add</button></center>
    </div>
    
<!-- <div class="clearfix">
	<center><input type="submit" value="submit" class="submitbtn" ></center>
	
</div>	 -->
</form>
</div>
</body>
</html>
