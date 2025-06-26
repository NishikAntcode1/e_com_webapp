package com.e_com_webapp.controller.product_controller;

import java.io.IOException;
import java.util.List;

import com.e_com_webapp.entity.Product;
import com.e_com_webapp.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class DisplayProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService service = new ProductService();
		List<Product> products = service.getAllProducts();

		req.setAttribute("productList", products);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
