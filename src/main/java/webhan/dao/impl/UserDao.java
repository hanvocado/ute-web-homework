package webhan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webhan.configs.DbConnect;
import webhan.dao.IUserDao;
import webhan.models.User;

public class UserDao implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<User> findAll() {
		String query = "SELECT * from users";
		List<User> users = new ArrayList<>();

		try {
			
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				users.add(new User(rs.getString("id"), rs.getString("email"), rs.getString("fullname"),
						rs.getString("password"), rs.getInt("roleId")));
			}
			conn.close(); 
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		String query = "SELECT * FROM users WHERE email=?";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("id"), rs.getString("email"), rs.getString("fullname"),
						rs.getString("password"), rs.getInt("roleId"));
			}
			conn.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {
		String query = "INSERT INTO users(email, fullname, password, roleId, id) VALUES (?, ?, ?, ?, ?)";

		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getRoleId());
			ps.setString(5, user.getId());
			ps.executeUpdate();
			conn.close(); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}

	@Override
	public User findById(String id) {
		String query = "SELECT * FROM users WHERE id=?";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("id"), rs.getString("email"), rs.getString("fullname"),
						rs.getString("password"), rs.getInt("roleId"));
			}
			conn.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePassword(String id, String newPS) {
		String query = "UPDATE users SET password=? WHERE id=?";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newPS);
			ps.setString(2, id);
			ps.executeUpdate();
			conn.close(); 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}

}