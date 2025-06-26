<%@page import="com.e_com_webapp.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Category category = (Category) request.getAttribute("category");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title>
<%@include file="cdn.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<div class="m-4">
			<form action="update_category" method="post">
				<%
				if (category != null) {
					int id = category.getCategorId();
					String name = category.getCategoryName();
					String desc = category.getCategoryDesc();
				%>
				<input type="hidden" name="id" value="<%=id%>">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input 
					value="<%=name%>" 
					name="categoryName" 
					type="text"
					class="form-control" 
					id="exampleFormControlInput1"
					placeholder="Electronics">
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
				  <textarea
				  name="categoryDesc" 
				  class="form-control" 
				  id="exampleFormControlTextarea1" 
				  rows="3"><%=desc%></textarea>
				</div>
				<button class="btn bg-orange" name="action" value="update" type="submit">Update</button>
    			<button class="btn btn-danger" name="action" value="delete" type="submit">Delete</button>
				<%
				} else {
				%>
				<h2>Category data not found.</h2>
				<%
				}
				%>
			</form>
		</div>

	</div>
</body>
</html>