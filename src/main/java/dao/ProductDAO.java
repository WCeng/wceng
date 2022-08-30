package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO {
	
	public ProductDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root",
				"admin");
	}
	
	public Product getProduct(int id) {
		Product result = null;
		
		String sql = "select * from product where id = ?";
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = new Product();
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				
				result.setId(id);
				result.setName(name);
				result.setPrice(price);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Product> ListProduct(){
		List<Product> products = new ArrayList<Product>();
		
		String sql = "select * from product order by id desc";
		try (Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	public static void main(String[] args) {
		System.out.println(new ProductDAO().ListProduct().size());
		System.out.println(new ProductDAO().getProduct(1).getName());
	}
}
