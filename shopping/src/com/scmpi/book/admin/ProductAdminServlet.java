package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.ProductServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

public class ProductAdminServlet extends HttpServlet {

	/*
	 * ��̨��Ʒ����
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//��ȡsession �洢��Ʒ������Ϣ
		HttpSession session = req.getSession(true);
		
		ProductService ps = new ProductServiceImpl();
		
		List<ProductType> ptype = new ArrayList<ProductType>();
		
		
		try {
			//��ȡ��Ʒ����
			ptype = ps.getProductTypes();
			
			//��ѯ������Ʒ��Ϣ
			List<Product> plist = ps.queryAll();	
			session.setAttribute("plist", plist);
			session.setAttribute("ptype", ptype);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//ҳ����ת
		req.getRequestDispatcher("/admin/product.jsp").forward(req, res);
		
		
		
		
	}

}
