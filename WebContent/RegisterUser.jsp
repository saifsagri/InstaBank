<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript" type="text/javascript">
function preventBack(){window.history.forward(1);}
setTimeout("preventBack()", 0);
window.onunload=function(){null};
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
   
<title>Insert title here</title>
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
<form action="register.do">
  <div class="container">
    
    <h2>Registration form</h2>
    <hr>
    
    <!-- 
	 * application_no number primary key,
 applicant_name varchar2(50),
 gender varchar2(1),
 email varchar2(50),
 phone varchar2(50),
 street_address varchar2(50),
 city varchar2(20),
 state varchar2(20),
 country varchar2(20),
 zipcode varchar2(10),
 branch int,
 dob date,
 aadhar varchar2(20),
 pancard varchar2(20),
 photo blob,
 signature blob
	 -->

    <div class="outer">
    <b><label for="Applicant Name" class="labelc"><b>Applicant Name</b></label>
    <input type="text" placeholder="Enter Name" name="applicant_name" pattern="[A-Za-z]{1,20}" required>
    <br>
    <br>

	<label for="gender" class="labelc"><b>Gender</b></label><br> 	
    <select id="gender" name="gender">
  	 <option value="Male">Male</option>
   	<option value="Female">Female</option>
   	</select> 
  
   	     <br>
   	   	     <br>
   	
<div>
     <label for="Email" class="labelc"><b>Email</b></label><br>
    <input type="email" placeholder="Enter email id" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
     <br>
     <br>
  </div>   
    <label for="Mobno" class="labelc"><b>Mobile no</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="phone" pattern="[0-9]{10}" required>
     <br>
      <br>

  <!--    Birthdate:
  	 <input type="date" name="bday">
  	 <input type="submit">
     <br>
     <br>  -->
  
     <label for="Address" class="labelc"><b>Address</b></label> 
    <input type="text" placeholder="Enter Street Address" name="street_address" required>
     <br>
      <br>
     
      <label for="City" class="labelc"><b>City</b></label>
    <select id="city" name="city">
  		<option value="mumbai">Mumbai</option>
   	</select> 
     <br>
     
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
   
      
        <label for="zipcode" class="labelc"><b>Zip-code</b></label>
    <input type="text" placeholder="Enter zipcode" name="zipcode" pattern="[0-9]{6}" required>
      <br>
      <br>
       
	<label for="Branch" class="labelc"><b>Branch</b></label>	
	<select id="branch" name="branch">
  	 <option value="Mahape">Mahape</option>
   	<option value="Powai">Powai</option>
   		
   	</select> 
    
 
      <br>
      <br>
       

      <label for="Adhar Card" class="labelc"><b>Aadhar Card</b></label>
    <input type="text" placeholder="Enter Adhar no" name="aadhar" pattern="[0-9]{12}" required>
     <br>
      <br>

      <label for="Pan Card" class="labelc"><b>Pan Card</b></label>
    <input type="text" placeholder="Enter Pan Card" name="pancard" pattern="[0-9a-zA-Z]{10}" required>
     <br>
      <br>

<!--  
		<table border="0">
                <tr>
                    <td>PHOTO</td>
                    <td><input type="file" name="photo" size="50" /></td>
                </tr>
                <tr>
                    <td>SIGNATURE</td>
                    <td><input type="file" name="signature" size="50" /></td>
                </tr>
            </table>
            
-->

    <div class="clearfix">
    <a href="home.jsp">  <button type="button" class="cancelbtn">Cancel</button></a>
      <button type="submit" class="registerbtn">Register</button>
    </div>
</form>
</div>

</body>
</html>