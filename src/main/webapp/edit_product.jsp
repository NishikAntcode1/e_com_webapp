<%@page import="com.e_comm_web.entity.Product"%>
<%@page import="com.e_comm_web.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
List<Category> categories = (List<Category>) request.getAttribute("categoryList");
Product product = (Product) request.getAttribute("product");
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
			<form action="update_product" method="post">
				<%
				if (product != null) {
					int id = product.getProductId();
					String name = product.getProductName();
					String desc = product.getProductDesc();
					double price = product.getProductPrice();
					int quantity = product.getProductQuantity();
					Category parentCat = product.getCategory();
				%>
				<input type="hidden" name="id" value="<%=id%>">
				<div class="row mb-4">
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="productName">Name</label> <input
								value="<%=name%>" name="productName" type="text"
								id="productName" class="form-control" />
						</div>
					</div>
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="categoryId">Category</label> <select
								class="form-select" name="categoryId"
								aria-label="Default select example">
								<option disabled>Select a category</option>
								<%
								if (categories != null && categories.size() != 0) {
									int selectedCategoryId = parentCat != null ? parentCat.getCategorId() : -1;
									for (Category category : categories) {
										int currentCategoryId = category.getCategorId();
										String selected = (currentCategoryId == selectedCategoryId) ? "selected" : "";
								%>
								<option value="<%=currentCategoryId%>" <%=selected%>><%=category.getCategoryName()%></option>
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
							<label class="form-label" for="form3Example1">Price</label> <input
								value="<%=price%>" name="price" type="number" id="price"
								class="form-control" />
						</div>
					</div>
					<div class="col">
						<div data-mdb-input-init class="form-outline">
							<label class="form-label" for="form3Example2">Quantity</label> <input
								value="<%=quantity%>" name="quantity" type="number"
								id="quantity" class="form-control" />
						</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="productDesc" class="form-label">Description</label>
					<textarea name="productDesc" class="form-control" id="productDesc"
						rows="3"><%=desc%></textarea>
				</div>
				<button class="btn bg-orange" name="action" value="update"
					type="submit">Update</button>
				<button class="btn btn-danger" name="action" value="delete"
					type="submit">Delete</button>
				<%
				} else {
				%>
				<h2>Product data not found.</h2>
				<%
				}
				%>
			</form>
		</div>

	</div>
</body>
</html>