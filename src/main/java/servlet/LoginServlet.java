package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class LoginServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new UserDAO().getUser(name, password);
		
		if(null != user) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("listProduct");
			
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
