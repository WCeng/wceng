package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class LogonServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter ouPrintWriter = response.getWriter();
		
		if("".equals(name) || "".equals(password)) {
			ouPrintWriter.write("�˺Ż�����Ϊ��");
			return;
		}
		
		List<User> users = new UserDAO().listUser();
		for(User us : users) {
			if(us.getName().equals(name)) {
				PrintWriter out = response.getWriter();
				out.write("���û��� "+us.getName()+" �Ѵ���");
				return;
			}
		}
		
		new UserDAO().addUser(name, password);
		ouPrintWriter.write("ע��ɹ�");
		
	}

}
