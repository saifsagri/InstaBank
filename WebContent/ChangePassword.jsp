<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="try.css">
<style> 

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;
}

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
<div class="outer">
 <form action="changePassword.do">
  <label class="labelc">Enter Login</label>
  <input type="text" name="login" placeholder="Enter LOGIN ID" required><br>
  
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


									<label class="labelc">Enter Password </label> <input class="form-control"
										name="password" id="password" type="password" placeholder="Eg: Ex@mple1" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
										onkeyup='check();' required />
									
									<br> 
									<label class="labelc">Confirm Password</label><input
										class="form-control" type="password" name="confirm_password"
										id="confirm_password" onkeyup='check();' placeholder="Confirm Password" required /> <span
										id='message'></span>
									
									
				
				<center><input type=submit name=submit class="submitbtn"></center>
				
			
	
</div>	</label>	
	
  
	
	<!-- <div class="clearfix">
     <center> <button type="button" class="submitbtn">Submit</button></center>
     
    </div>
	 -->
</form> 
</div>
</body>
</html>
