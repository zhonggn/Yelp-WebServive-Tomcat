<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
    <%@ page import="model.Review" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User information</title>
</head>
<body>
<p>

<%
User user = (User)request.getAttribute("user");
Review[] review = (Review[])request.getAttribute("review");
%>
First name: <%= user.getFname() %><br>
Last name: <%= user.getLname() %><br>
Email address: <%= user.getEmail() %><br>
Last login time: <%= user.getLtime() %><br>

 <div>Reviews: <br>
    
      <%
       if(review != null){
       for(int i=0; i<review.length;i++){
       if(review[i] != null){%>
       <div> To: <%= review[i].getEname()%><br>
       Content: <%= review[i].getContent()%><br>
       Rate: <%= review[i].getRate()%><br>
       </div>
       <%}}}%>
 </div>
	
</p>
</body>
</html>