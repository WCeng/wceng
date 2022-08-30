package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.OrderItem;

public class OrderItemDAO {
	
	public void insert(OrderItem oi) {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
	            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
	                    "root", "admin");
	 
	            String sql = "insert into orderitem values(null,?,?,?)";
	            
	            PreparedStatement ps = c.prepareStatement(sql);
	            
	            ps.setInt(1, oi.getProduct().getId());
	            ps.setInt(2, oi.getNum());
	            ps.setInt(3, oi.getOrder().getId());
	            
	            ps.execute();
	            
	            ps.close();
	            c.close();
	            
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
