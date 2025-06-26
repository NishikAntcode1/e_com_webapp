package com.e_com_webapp.service;

import java.util.List;

import com.e_com_webapp.dao.ProductDao;
import com.e_com_webapp.entity.Product;

public class ProductService {
	private ProductDao productDao = new ProductDao();
	
	public void addProduct(Product product) {
		productDao.save(product);
	}
	
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	public Product getProductById(int id) {
		return productDao.findById(id);
	}
	
	public void updateProduct(Product prod) {
		Product product = productDao.findById(prod.getProductId());
		if (product != null) {
			productDao.update(prod);
		}
	}

	public void deleteProduct(int id) {
		productDao.delete(id);
	}
}
