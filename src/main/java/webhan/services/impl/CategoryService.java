package webhan.services.impl;

import java.util.List;

import webhan.models.Category;
import webhan.services.ICategoryService;
import webhan.dao.ICategoryDao;
import webhan.dao.impl.CategoryDao;

public class CategoryService implements ICategoryService {
	ICategoryDao categoryDao = new CategoryDao();
	@Override
	public void insert(Category category) {
		categoryDao.insert(category);		
	}

	@Override
	public void edit(Category category) {
		categoryDao.edit(category);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);		
	}

	@Override
	public Category find(int id) {
		return categoryDao.find(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> search(String keyword) {
		return categoryDao.search(keyword);
	}

}
