package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.DBConnection;
import model.Product;

public class ProductDAO implements DAO<Product, Integer> {
	DBConnection db = new DBConnection();

	public ProductDAO() {
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		Connection con = null;
		try {
			con = db.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("SELECT id, name, category, price, quantity, description FROM product");
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String category = result.getString("category");
				int price = result.getInt("price");
				int amount = result.getInt("quantity");
				String description = result.getString("description");

				list.add(new Product(id, name, category, price, amount, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		db.closeConnection();
		return list;
	}

	@Override
	public Product get(Integer k) {
		Product product = null;
		
		Connection con = null;
		try {
			con = db.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			String sql = "select id, name, category, price, quantity, description from product where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, k);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				int amount = rs.getInt("quantity");
				String description = rs.getString("description");
				
				product = new Product(id, name, category, price, amount, description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean add(Product t) {
		int result = -1;
		Connection con = null;
		try {
			con = db.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			String sql = "INSERT INTO product (name, category, price, quantity, description) values (?,?,?,?,?)";
			PreparedStatement stm = con.prepareStatement(sql);

			String name = t.getNameProduct();
			String cate = t.getCategory();
			int price = t.getPrice();
			int quantity = t.getAmount();
			String description = t.getDescription();

			stm.setString(1, name);
			stm.setString(2, cate);
			stm.setInt(3, price);
			stm.setInt(4, quantity);
			stm.setString(5, description);

			result = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result > 0;
	}

	@Override
	public boolean update(Product t) {
		int result = -1;

		Connection con = null;
		try {
			con = db.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		String sql = "update product set name = ?, category = ?, price = ?, quantity = ?, description = ? where id = ?";

		try {
			PreparedStatement updateStmt = con.prepareStatement(sql);
			updateStmt.setString(1, t.getNameProduct());
			updateStmt.setString(2, t.getCategory());
			updateStmt.setInt(3, t.getPrice());
			updateStmt.setInt(4, t.getAmount());
			updateStmt.setString(5, t.getDescription());
			updateStmt.setInt(6, t.getIdProduct());

			result = updateStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result > 0;
	}

	@Override
	public boolean delete(Product t) {
		int result = -1;
		Connection con = null;
		try {
			con = db.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			String sql = "delete product where id = ?";
			PreparedStatement deleteStmt = con.prepareStatement(sql);
			deleteStmt.setInt(1, t.getIdProduct());
			result = deleteStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result > 0;
	}
}
