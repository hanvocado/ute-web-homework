package webhan.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import webhan.dao.IUserDao;
import webhan.dao.impl.*;
import webhan.models.User;

public class DbConnect {
	// init database constants
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ute_web";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "666666";

	public Connection getDatabaseConnection() throws Exception {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		IUserDao userDao = new UserDao();
		/*
		 * User user = userDao.findByEmail("test1@ute.com"); System.out.println(user);
		 */

		/*
		 * List<User> users = userDao.findAll(); for (User user : users) {
		 * System.out.println(user); }
		 */

		userDao.insert(new User("746fbfj8bvjdu8", "han2@test.com", "Nguyễn Hân", "12345", 1));
	}

}