<%@page import="com.e_com_webapp.entity.Category"%>
<%@page import="com.e_com_webapp.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
List<Product> products = (List<Product>) request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="cdn.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<div class="m-4">
			<a class="btn bg-orange float-end m-2" href="create_category_form">New
				Product</a>
		</div>
		<div class="m-4">
			<table class="table table-hover border-start border-end">
				<thead>
					<tr class="table-active">
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Quantity</th>
						<th>Category</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (products != null && products.size() != 0) {
						for (Product product : products) {
							int id = product.getProductId();
							String name = product.getProductName();
							String desc = product.getProductDesc();
							int quantity = product.getProductQuantity();
							Category category = product.getCategory();
							
					%>
					<tr onclick="window.location='edit_product?id=<%=id%>'" style="cursor: pointer;">
						<td><%= id%></td>
						<td><%= name%></td>
						<td><%= (desc.length() > 30 ? desc.substring(0, 30) + "..." : desc) %></td>
						<td><%= quantity%></td>
						<td><%= category.getCategoryName()%></td>
					</tr>
					<%
                        }
                    } else {
                %>
                <tr>
                    <td align="center" colspan="3">No products found.</td>
                </tr>
                <% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>