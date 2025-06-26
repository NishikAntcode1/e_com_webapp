package com.e_com_webapp.controller.category_controller;

import java.io.IOException;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit_category")
public class EditCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService s = new CategoryService();
		int id = Integer.parseInt(req.getParameter("id"));
		
		Category category = s.getCategoryById(id);

        req.setAttribute("category", category);

        req.getRequestDispatcher("edit_category.jsp").forward(req, resp);

	}

}
