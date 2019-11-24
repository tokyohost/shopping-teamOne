package com.scmpi.book.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.impl.OrderServiceImpl;

public class ReceiptServlet extends HttpServlet {

	/*
	 * �û��޸Ķ���״̬
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//��ȡsession �洢��Ʒ������Ϣ
		HttpSession session = req.getSession(true);
		
		//��ȡ��Ҫ�޸ĵĶ���uuid��Ϣ
//		User u = (User) session.getAttribute("user");	
		Order o = new Order();
		o.setUuid(req.getParameter("uuid"));
		
		OrderService os = new OrderServiceImpl();
		
		try {
			os.updateStatus(o, "��ǩ��");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		}
		
		
		// ҳ����ת
		
//		res.sendRedirect("/shopping/ordershow.jsp");
		req.getRequestDispatcher("/OrderShowServlet").forward(req, res);
		
		
		
		
	}
	

}
