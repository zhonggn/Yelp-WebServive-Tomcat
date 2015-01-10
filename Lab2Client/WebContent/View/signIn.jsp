<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-In</title>
<style type="text/css">
body{
	text-align: center;
}
</style>
</head>
<body>
<div><b> Sign In </b></div><br>
<form id="form1" method="post" action="signIn" >  
      <div class="form-row"><span class="label">Email *</span><input type="text" name="email" placeholder="Email"/></div>  
      <div class="form-row"><span class="label">Password *</span><input type="password" name="pass" placeholder="password"/></div> 
      <div class="form-row"><input class="submit" type="submit" value="Submit"></div> 
</form> 
<div><b> Do not have an account yet? Get one! </b></div><br>
<a href="./SignUp.jsp">Sign Up</a>
</body>
</html>