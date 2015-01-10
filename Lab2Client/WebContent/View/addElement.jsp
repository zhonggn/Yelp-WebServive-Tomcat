<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
Welcome to add element
<form action="doAddElem" method="post" class="doAddElem">
    	<input type="text" class="form-control" name="inputElemName" id="inputElemName" placeholder="Element Name"><br>
    	<input type="text" class="form-control" name="inputDecription" id="inputDescription" placeholder="Description"><br>
    	<input type="text" class="form-control" name="inputRate" id="inputRate" placeholder="Rate"><br>
    	<input type="text" class="form-control" name="inputCatName" id="inputCatName" placeholder="Category Name"><br>
    	<input type="text" class="form-control" name="inputReviews" id="inputReviews" placeholder="Reviews"><br>
    	<button type="submit" class="btn btn-primary">Add</button>
</form>

</p>
</body>
</html>