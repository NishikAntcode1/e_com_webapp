package com.e_com_webapp.controller.product_controller;

import java.io.IOException;
import java.util.List;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.entity.Product;
import com.e_com_webapp.service.CategoryService;
import com.e_com_webapp.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit_product")
public class EditProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService pservice = new ProductService();
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = pservice.getProductById(id);
		req.setAttribute("product", product);
		
		CategoryService cservice = new CategoryService();
		List<Category> categories = cservice.getAllCategories();
		req.setAttribute("categoryList", categories);
		
		req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
	}

}
