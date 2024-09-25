package webhan.services;

import java.util.List;

import webhan.models.Category;

public interface ICategoryService {
	void insert(Category category);
	void edit(Category category);
	void delete(int id);
	Category find(int id);
	List<Category> findAll();
	List<Category> search(String keyword);
}
