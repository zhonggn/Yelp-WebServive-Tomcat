<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete-category</title>
</head>
<body>
<h2>Input a category</h2>

<form action="doDeleteCat" method="post" class="doDeleteCat">
    	<input type="text" class="form-control" name="inputCategory" id="inputCategory" placeholder="Category name">
    	<button type="submit" class="btn btn-primary">Delete</button>
</form>
    
</body>
</html>