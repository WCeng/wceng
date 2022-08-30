package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;

public class OrderDAO {

	public void insert(Order o) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "admin");
 
            String sql = "insert into order_ values(null,?)";
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, o.getUser().getId());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
            	int id = rs.getInt(1);
            	o.setId(id);
            }
            
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
