<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Category</title>
<%@include file="cdn.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<div class="m-4">
			<form action="create_category" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label> 
					<input 
					name="categoryName"
					type="text"
					class="form-control"
					id="exampleFormControlInput1"
					placeholder="Electronics">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Description</label>
					<textarea 
					name="categoryDesc"
					class="form-control" 
			        id="exampleFormControlTextarea1" 
					rows="3"></textarea>
				</div>
				<button class="btn bg-orange" type="submit" >Create</button>
			</form>
		</div>

	</div>
</body>
</html>