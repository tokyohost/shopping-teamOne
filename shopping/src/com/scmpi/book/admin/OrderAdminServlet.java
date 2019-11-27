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

import com.scmpi.book.dao.OrderDao;
import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.OrderServiceImpl;
import com.scmpi.book.service.impl.ProductServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

public class OrderAdminServlet extends HttpServlet {

	/**
	 * ��̨��������
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//��ȡsession �洢��Ʒ������Ϣ
		HttpSession session = req.getSession(true);
		
		OrderDao od = new OrderDaoImpl();
		UserService os = new UserServiceImpl();
		List<Order> oList = new ArrayList<Order>();
		
		
		try {
			//��ȡ���ж���
			oList = od.queryAllOrder();
			//��ȡ��������
			int orderNum = oList.size();
			
			//��ѯ�����û���Ϣ
			List<User> ulist = os.queryAllUser();	
			session.setAttribute("ulist", ulist);
			session.setAttribute("olist", oList);
			session.setAttribute("orderNum", orderNum);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//ҳ����ת
		req.getRequestDispatcher("/admin/order.jsp").forward(req, res);
		
	}

}
