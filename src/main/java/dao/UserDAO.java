package dao;

import java.awt.image.PackedColorModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO {

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root",
				"admin");
	}

	public User getUser(String name, String password) {
		User result = null;
		
		String sql = "select * from user where name = ? and password = ?";

		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = new User();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setPassword(rs.getString(3));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void addUser(String name, String password) {
		String sql = "insert into user values(null, ?, ?)";
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setString(2, password);
			
			ps.execute();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<User> listUser() {
		
		List<User> users = new ArrayList<User>();
		
		String sql = "select * from user";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				
				User u = new User();
				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				
				users.add(u);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new UserDAO().listUser().size());
	}
}
