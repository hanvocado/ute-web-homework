package webhan.services.impl;

import webhan.models.User;
import webhan.services.IUserService;
import webhan.utils.Constant;

import java.util.UUID;

import webhan.dao.IUserDao;
import webhan.dao.impl.UserDao;

public class UserService implements IUserService {
	IUserDao userDao = new UserDao();

	@Override
	public User login(String email, String password) {
		User user = userDao.findByEmail(email);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}

		return null;
	}

	public User findById(String id) {
		return userDao.findById(id);
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public boolean register(String email, String password, String fullname) {
		if (userDao.findByEmail(email) != null) {
			return false;
		}
		String id = UUID.randomUUID().toString();
		userDao.insert(new User(id, email, fullname, password, Constant.CUSTOMER_ID));
		return true;
	}

	@Override
	public boolean isEmailExisted(String email) {
		if (userDao.findByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(String id, String newPS) {
		return userDao.updatePassword(id, newPS);
	}
}
