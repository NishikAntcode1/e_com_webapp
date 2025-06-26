package com.e_com_webapp.controller.product_controller;

import java.io.IOException;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.entity.Product;
import com.e_com_webapp.service.CategoryService;
import com.e_com_webapp.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update_product")
public class UpdateProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
	    int id = Integer.parseInt(req.getParameter("id"));
	    
	    if ("update".equals(action)) {
	    	String productName = req.getParameter("productName");
			String productDesc = req.getParameter("productDesc");
			double price = Double.parseDouble(req.getParameter("price"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int categoryId = Integer.parseInt(req.getParameter("categoryId"));
			
			CategoryService categoryService = new CategoryService();
			
			Category category = categoryService.getCategoryById(categoryId);
	        
			Product product = new Product();
			product.setProductId(id);
			product.setProductName(productName);
			product.setProductDesc(productDesc);
			product.setProductPrice(price);
			product.setProductQuantity(quantity);
			product.setCategory(category);
	        
			ProductService productService = new ProductService();
			productService.updateProduct(product);
	        resp.sendRedirect("home");

	    } else if ("delete".equals(action)) {
	        ProductService productService = new ProductService();
	        productService.deleteProduct(id);
	        resp.sendRedirect("home");
	    }
	}

}
