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
<title>Categories</title>
<%@include file="cdn.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<div class="m-4">
			<a class="btn bg-orange float-end m-2" href="create_category.jsp">New
				Category</a>
		</div>
		<div class="m-4">
			<table class="table table-hover border-start border-end">
				<thead>
					<tr class="table-active">
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (categories != null && categories.size() != 0) {
						for (Category category : categories) {
							int id = category.getCategorId();
							String name = category.getCategoryName();
							String desc = category.getCategoryDesc();
					%>
					<tr onclick="window.location='edit_category?id=<%=id%>'" style="cursor: pointer;">
						<td><%=id%></td>
						<td><%=name%></td>
						<td><%= (desc.length() > 30 ? desc.substring(0, 30) + "..." : desc) %></td>
					</tr>
					<%
                        }
                    } else {
                %>
                <tr>
                    <td align="center" colspan="3">No categories found.</td>
                </tr>
                <% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>