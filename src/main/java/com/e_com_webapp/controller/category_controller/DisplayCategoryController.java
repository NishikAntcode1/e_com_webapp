package com.e_com_webapp.controller.category_controller;

import java.io.IOException;
import java.util.List;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/all_categories")
public class DisplayCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService service = new CategoryService();
		List<Category> categories = service.getAllCategories();
		
		req.setAttribute("categoryList", categories);

		req.getRequestDispatcher("all_categories.jsp").forward(req, resp);
	}

}
