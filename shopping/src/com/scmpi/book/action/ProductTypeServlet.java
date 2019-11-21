package com.scmpi.book.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Product;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class ProductTypeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String ptid=request.getParameter("ptid");
		ProductService pservice=new ProductServiceImpl();
		try {
			List<Product> products=pservice.queryPdtsById(Integer.parseInt(ptid));
			HttpSession session = request.getSession(true);
			session.setAttribute("products", products);
			session.setAttribute("condtion", "condtion");
			request.getRequestDispatcher("/servlet/PageServlet").forward(request, response);
		}  catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
