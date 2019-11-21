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
		String username = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		User user = new User(address, email, username, pwd, phone, postcode);
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
