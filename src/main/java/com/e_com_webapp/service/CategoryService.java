package com.e_com_webapp.service;

import com.e_com_webapp.dao.CategoryDao;
import com.e_com_webapp.entity.Category;

import java.util.List;

public class CategoryService {

	private CategoryDao categoryDao = new CategoryDao();

	public void addCategory(Category category) {
		categoryDao.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}

	public Category getCategoryById(int id) {
		return categoryDao.findById(id);
	}

	public void updateCategory(Category cat) {
		Category category = categoryDao.findById(cat.getCategorId());
		if (category != null) {
			categoryDao.update(cat);
		}
	}

	public void deleteCategory(int id) {
		categoryDao.delete(id);
	}
}
