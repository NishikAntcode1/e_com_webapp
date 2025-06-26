package com.e_com_webapp.controller.category_controller;

import java.io.IOException;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update_category")
public class UpdateCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String action = req.getParameter("action");
	    int id = Integer.parseInt(req.getParameter("id"));
	    
	    if ("update".equals(action)) {
	        String name = req.getParameter("categoryName");
	        String desc = req.getParameter("categoryDesc");
	        Category category = new Category();
	        category.setCategorId(id);
	        category.setCategoryName(name);
	        category.setCategoryDesc(desc);
	        CategoryService s = new CategoryService();
	        s.updateCategory(category);
	        resp.sendRedirect("all_categories");

	    } else if ("delete".equals(action)) {
	        CategoryService s = new CategoryService();
	        s.deleteCategory(id);
	        resp.sendRedirect("all_categories");
	    }
	}


}
