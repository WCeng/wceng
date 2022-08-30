package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;
import bean.Product;
import bean.User;
import dao.ProductDAO;

public class OrderItemListServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		Product product = new ProductDAO().getProduct(pid);
//		System.out.println(product.getName());
		
		OrderItem oi = new OrderItem();
		oi.setNum(num);
		oi.setProduct(product);
		
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		
		boolean found = false;
		if(ois != null) {
			for(OrderItem orderItem : ois) {
				if(orderItem.getProduct().getId() == oi.getProduct().getId()) {
					
					int orderItemNum = orderItem.getNum() + oi.getNum();
					orderItem.setNum(orderItemNum);
					
					found = !found;
					break;
				}
			}
		}
		
		if(!found) {
			if(ois == null) {
				ois = new ArrayList();
			}
			ois.add(oi);
			request.getSession().setAttribute("ois", ois);
		}
		
		
		
		request.getRequestDispatcher("listOrderItem.jsp").forward(request, response);
		
	}
}
