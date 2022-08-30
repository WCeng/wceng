package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

public class ProductListServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		List<Product> products = new ProductDAO().ListProduct();
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("listProduct.jsp").forward(request, response);
		
	}

}
