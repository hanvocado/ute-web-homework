package webhan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webhan.configs.DbConnect;
import webhan.dao.ICategoryDao;
import webhan.models.Category;

public class CategoryDao implements ICategoryDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(Category category) {
		String sql = "INSERT INTO categories (name, icon, image) VALUES (?,?,?)";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getIcon());
			ps.setString(3, category.getImage());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(Category category) {
		String sql = "UPDATE categories SET name = ?, icon=?, deleted=? WHERE id = ?";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getIcon());
			ps.setBoolean(3, category.isDeleted());
			ps.setInt(4, category.getId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "UPDATE categories SET deleted = ? WHERE id = ?";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Category find(int id) {
		String sql = "SELECT * FROM category WHERE id = ? ";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("icon"), rs.getBoolean("deleted"), rs.getString("image"));

				conn.close();
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM categories";
		try {
			conn = new DbConnect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("icon"), rs.getBoolean("deleted"), rs.getString("image"));

				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Category> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
