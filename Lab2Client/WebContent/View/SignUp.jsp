<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>
<style type="text/css">
body{
	text-align: center;
}
</style>
</head>
<body>
<div><b> Sign Up for New Account </b></div><br>
<form id="form1" method="post" action="SignUp" >  
	  <div class="form-row"><span class="label">FirstName *</span><input type="text" name="fname"  placeholder="First Name"/></div>  
      <div class="form-row"><span class="label">LastName *</span><input type="text" name="lname" placeholder="Last Name"/></div> 
      <div class="form-row"><span class="label">Email *</span><input type="email" name="email" placeholder="Email"/></div>  
      <div class="form-row"><span class="label">Password *</span><input type="password" name="pass" placeholder="Password"/></div> 
      <div class="form-row"><input class="submit" type="submit" value="Submit"></div> 
</form> 

</body>
</html>