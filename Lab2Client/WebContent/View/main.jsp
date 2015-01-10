<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Category" %>
<%@ page import="model.Element" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Yelp</title>
</head>
<body>
<%= session.getAttribute("message") %>
<h2>Welcome to Yelp</h2>
<form id="form3" method="post" action="showUserInfo" >  
      
      <div class="form-row"><input class="submit" type="submit" value=<%= session.getAttribute("email") %>></div> 
</form>




<div> Categories:
<p>
<%
Category[] clist = (Category[])request.getAttribute("category");
Element[] eList = (Element[])request.getAttribute("element");
%>
	<%
	if(clist !=null){
	for(int i=0; i<clist.length; i++){
	if(clist[i] != null){%>
	<div> <a href="/Lab2Client/View/main?cid=<%=clist[i].getCid()%>"><span class = "category-title"><%=clist[i].getCname()%></span></a><br> </div>
	<%}}} else{System.out.println("null");} %>
	
	<h1>Elements list:</h1>
	
          <%
          if(eList != null){
        	  for(int j=0; j<eList.length; j++){
        	  if(eList[j] != null){%>
          <li class="media-block media-block-large clearfix"><div class="media-story"><div class="media-title"><span class="indexed-biz-name"><a class="biz-name" href="/Lab2Client/View/eleinfo?eid=<%=eList[j].getEid()%>"><%=eList[j].getEname()%></a></span></div><div><div class="biz-rating biz-rating-medium clearfix"><div class="rating"><span>Rating: <%=eList[j].getRating()%>/5.0</span></div></div></div></div></li>
          <%}}}%>
	 
	
	
	
	 <form action="addCategory" method="get" class="addCategory">
      	 <button type="submit" class="btn btn-primary">Add Category</button>
      </form>
      
      <form action="addElement" method="get" class="addElem">
      	 <button type="submit" class="btn btn-primary">Add Element</button>
      </form>
      
      <form action="deleteCat" method="get" class="deleteCat">
      	 <button type="submit" class="btn btn-primary">Delete Category</button>
      </form>
      
      <form action="deleteElem" method="get" class="deleteElem">
      	 <button type="submit" class="btn btn-primary">Delete Element</button>
      </form>
      <form action="signOut" method="get" class="signOut">
      	 <button type="submit" class="btn btn-primary">Sign Out</button>
      </form>
	
</p>
</div>
</body>
</html>