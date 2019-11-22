package com.scmpi.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scmpi.book.entity.User;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String uname = request.getParameter("userName");
		String upasswd = request.getParameter("password");
		String email = request.getParameter("email");
		String usex = request.getParameter("sex");
		String uphone = request.getParameter("phone");
		String uaddress = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		
		
		
		User user = new User(uname,upasswd,email,usex,birthday,uphone,uaddress, 0, 100, 0);
		// 回调服务层
		UserService userService = new UserServiceImpl();
		try {
			userService.addUser(user);
			request.getRequestDispatcher("/registerOk.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}
	}

}
