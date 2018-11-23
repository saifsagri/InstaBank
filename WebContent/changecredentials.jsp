<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Credentials</title>
<link rel="stylesheet" type="text/css" href="try.css">
<style> 

input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}


</style>
</head>
<body background="bg2.jpg">
<div style="color:red">${invalid}</div><br>
<div class="outer">
<form action="changeCredentials.do">
<label class="labelc">Old Password:</label><input type="password" name="oldPassword" placeholder="Enter your Old Password" required><br>

		<label><div>

									<script type="text/javascript">
										var check = function() {
											if (document
													.getElementById('password').value == document
													.getElementById('confirm_password').value) {
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


									<label class="labelc">Enter New Password </label> <input class="form-control"
										name="newPassword" id="password" type=password placeholder="Eg: Ex@mple1" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
										onkeyup='check();' required />
									
									<br> 
									<label class="labelc">Confirm New Password</label><input
										class="form-control" type="password" name="confirm_password"
										id="confirm_password" onkeyup='check();' placeholder="Confirm New Password" required/> <span
										id='message'></span>
									
									
				
				
				
			
	
</div>	</label>	
	
	
	
	
	<div class="clearfix">
      <a href="myprofile1.jsp"><button type="button" class="cancelbtn">Cancel</button></a>
      <button type="submit" class="registerbtn">Submit</button>
    </div>

</form>
</div>


</body>
</html>



<!-- <form action="credentialschanged.jsp"></form>				
									<center><input type="submit" value="submit" class="submitbtn"></center>	
							</form> -->