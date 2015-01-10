<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add-review</title>
</head>
<body>
<h2>Welcome to add review:</h2>
<%
int eid = (Integer)request.getAttribute("eid");

%>
  Element id: <%= eid%>
     <form action="doAddreview" method="post" class="doAddreview">
     <input type="text" class="form-control" name="inputReview" id="inputReview" placeholder="Content">
     <input type="text" class="form-control" name="inputRate" id="inputRate" placeholder="Rate">
     <input type="text" class="form-control" name="inputEleId" id="inputEleId" placeholder="Element ID">
  	 <button type="submit" >Add</button>
     </form>
     
     
     
     
     
     
</body>
</html>