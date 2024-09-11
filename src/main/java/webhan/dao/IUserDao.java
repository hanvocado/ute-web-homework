package webhan.dao;

import java.util.List;

import webhan.models.User;

public interface IUserDao {
	List<User> findAll();

	User findByEmail(String email);
	
	User findById(String id);

	void insert(User user);
	
	boolean updatePassword(String id, String newPS);
}
