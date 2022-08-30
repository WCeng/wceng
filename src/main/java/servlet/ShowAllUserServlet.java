package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class ShowAllUserServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		List<User> users = new UserDAO().listUser();
//		System.out.println(users.size());
		request.setAttribute("users", users);
		
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

}
