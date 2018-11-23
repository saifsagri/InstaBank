<html>
<head> 
  <link rel="stylesheet" href="myprofile.css">
  <link rel="stylesheet" type="text/css" href="try.css">
  <style> 

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;


}
input[type=button] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #804040;


}

</style>
<div class="topnav">
  <a class="active" href=#>Add</a>
 
  <a href="interdeleteben.jsp">Delete</a>
    <a href="interviewallben.jsp">View all</a>
  
  
</div>

<script type="text/javascript">
    function poll(){
        var url="/ajaxpollng";
        $.ajax({
            url:url,
            dataType:'text',
            async:true,
            beforeSend:function(request){
                request.setRequestHeader("IS_AJAX_POLL","Y");
            },
            type:'POST',
            success:function(data,testStatus,request){
                var isSessionTimeout=request.getResponseHeader("IS_SESSION_TIMEOUT");
                if(isSessionTimeout!=null && isSessionTimeout=='Y'){
                    logout();
                }
            }
        });
    }
     
    function logout(){
        window.location.href="/logout.do"; // Logout action or time out page.
    }
</script>
<script type="text/javascript">
    setInterval("poll()",30000);//Polling Server every 30 seconds.
</script>


</head>
<body background="bg2.jpg">
<h1 style="color:#804040;"> ADD INTERBANK BENEFICARY</h1><br><br>
<div class="outer" >
<form>
<label class="labelc"><b>Name:</b></label><input type="text" name="name" placeholder="Enter Name" required><br>
<br>
<label class="labelc"><b>Street Address:</b></label><input type="text" name="streetaddress" placeholder="Enter Street-Address" required><br>
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


									<label class="labelc"><b>Enter Account Number </b></label> <input class="form-control"
										name="benAccountId" id="accountnumber" type="text"
										onkeyup='check();' placeholder="Enter Account Number" pattern="[0-9]{8}" required />
									
									<br> <br>
									<label class="labelc"><b>Confirm Account Number</b></label><input
										class="form-control" type="text" name="confirmaccountnumber"
										id="confirmaccountnumber" onkeyup='check();' placeholder="Confirm Account Number" required /> <span
										id='message'></span>
									
								</div>
<br>


<label for="City" class="labelc"><b>City</b></label>
    <select id="city" name="city">
  	 <option value="mumbai">Mumbai</option>
   	<option value="pune">Pune</option>
   	</select> <br>
<label for="State" class="labelc"><b>State</b></label>
     <select id="state" name="state">
   		<option value="Maharashtra">Maharashtra</option>
   	 </select>
      <br>
      <br>    

     <label for="Country" class="labelc"><b>Country</b></label>	
	 <select id="country" name="country">
   	<option value="India">India</option>
   	</select>
      <br>
      <br>

<label class="labelc"><b>Zipcode:</b></label><input type="text" name="zipcode" pattern="[0-9]{6}" placeholder="Example:400012" required><br>
<br>
<label class="labelc"><b>IFSC:</b></label><input type="text" name="ifsc" placeholder="Enter IFSC-Code" required ><br>
<br>



<div class="clearfix">
<div class="clearfix">
      
      <center><button type="submit" class="submitbtn">Add</button></center>
    </div>
    
</form>
</div>
</body>
</html>