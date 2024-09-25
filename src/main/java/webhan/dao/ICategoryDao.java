package webhan.dao;

import java.util.List;

import webhan.models.Category;

public interface ICategoryDao {
	void insert(Category category);
	void edit(Category category);
	void delete(int id);
	Category find(int id);
	List<Category> findAll();
	List<Category> search(String keyword);
}
