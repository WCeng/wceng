package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

public class OrderCreateServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		
		User user = (User) request.getSession().getAttribute("user");
		if(null == user) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		Order order = new Order();
		order.setUser(user);
		new OrderDAO().insert(order);
		
		
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		
		for(OrderItem oi : ois) {
			oi.setOrder(order);
			new OrderItemDAO().insert(oi);
			
		}
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("订单创建成功");
	}

}
