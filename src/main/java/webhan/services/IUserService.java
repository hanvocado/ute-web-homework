package webhan.services;

import webhan.models.User;

public interface IUserService {
	User login(String email, String password);

	User findById(String id);
	
	User findByEmail(String Email);

	boolean register(String email, String password, String fullname, String img, String phone);
	
	boolean isEmailExisted(String email);
	
	boolean updatePassword(String id, String newPS);
	
	User updateUser(User user);
}
