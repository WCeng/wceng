package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

public class OrderItemDeleteServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		List<OrderItem> deleteoi = new ArrayList();
		
		if(null != ois) {
			for(OrderItem oi : ois) {
				if(oi.getProduct().getId() == pid) {
					deleteoi.add(oi);
					break;
				}
			}
		}
		
		ois.removeAll(deleteoi);
		
		response.sendRedirect("listOrderItem.jsp");
	}
}
