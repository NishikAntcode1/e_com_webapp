package com.e_com_webapp.controller.category_controller;

import java.io.IOException;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create_category")
public class CreateCategoryController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService service = new CategoryService();
		try {
			String categoryName = req.getParameter("categoryName");
			String categoryDesc = req.getParameter("categoryDesc");
			Category category = new Category();
			category.setCategoryName(categoryName);
			category.setCategoryDesc(categoryDesc);
			
//			System.out.println(category.getCategoryName()+" "+ category.getCategoryDesc());
			
			service.addCategory(category);
			resp.sendRedirect("all_categories");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
