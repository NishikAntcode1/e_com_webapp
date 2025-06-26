package com.e_com_webapp.controller.product_controller;

import java.io.IOException;
import java.util.List;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create_category_form")
public class CreateProductFormController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService service = new CategoryService();
		List<Category> categories = service.getAllCategories();
		req.setAttribute("categoryList", categories);
		req.getRequestDispatcher("create_product.jsp").forward(req, resp);
	}

}
