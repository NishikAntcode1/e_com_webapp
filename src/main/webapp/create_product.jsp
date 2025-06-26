<%@page import="com.e_com_webapp.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
List<Category> categories = (List<Category>) request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<%@include file="cdn.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<div class="m-4">
			<form action="create_product" method="post">

				<div class="row mb-4">
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="form3Example1">Name</label> 
							<input
								name="productName"
								type="text" 
								id="productName" 
								class="form-control" />
						</div>
					</div>
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="form3Example2">Category</label> 
							<select
								class="form-select" 
								name="categoryId"
								aria-label="Default select example">
								<option disabled selected>Select a category</option>
								<%
								if (categories != null && categories.size() != 0) {
									for (Category category : categories) {
								%>
								<option value="<%=category.getCategorId()%>"><%=category.getCategoryName()%></option>
								<%
								}
								} else {
								%>
								<option disabled>No categories available</option>
								<%
								}
								%>
							</select>
						</div>
					</div>
				</div>

				<div class="row mb-4">
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="form3Example1">Price</label>
							<input 
								name="price"
								type="number" 
								id="price" 
								class="form-control" />
						</div>
					</div>
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="form3Example2">Quantity</label> 
							<input
								name="quantity"
								type="number" 
								id="quantity" 
								class="form-control" />
						</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Description</label>
					<textarea name="productDesc" class="form-control"
						id="productDesc" rows="3"></textarea>
				</div>
				<button class="btn bg-orange" type="submit">Create</button>
			</form>
		</div>

	</div>
</body>
</html>