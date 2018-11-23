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



<link rel="stylesheet" type="text/css" href="try.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg2.jpg">
<br>
<br>
<br>
<br>
<center>
<div class="outer">
<h3 style="color:#804040;"> Please Select Transfer Type</h3>
 <div class="dropdown">
<center><button onclick="myFunction()" class="dropbtn">Transfer Type</button></center>
  <div id="myDropdown" class="dropdown-content">
  
    <a href="QuickTransfer.jsp">Quick Transfer</a> 
   <a href="intertransfer.jsp">Inter Transfer</a> 
    <a href="intratransfer.jsp">Intra Transfer</a>
  </div>
</div>
</div>
</center>

<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
  
</form>

</body>
</html>