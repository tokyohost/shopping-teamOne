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
import com.scmpi.book.dao.ProductDao;
import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.dao.impl.ProductDaoImpl;
import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.ProductServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

public class SearchOrderServlet extends HttpServlet {

	/**
	 * ��̨��������
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		HttpSession session = req.getSession(true);
		
		ProductService ps = new ProductServiceImpl();
		try {
			String keyName = req.getParameter("qureyKey");
			
		
			if(keyName == ""){
				
				ErrorMsg em = new ErrorMsg();
				em.setMsg("��ѯʧ�ܣ����������Ƿ���ȷ��");
				em.setFoxurl("/servlet/OrderAdminServlet");
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
			}else{
				//��ѯ�����û�
				UserService us = new UserServiceImpl();
				List<User> ulist = us.queryAllUser();
				
				OrderDao od = new OrderDaoImpl();
				List<Order> oList = od.queryAllOrder();	//��ѯ���ж���
				List<Order> sList = new ArrayList<Order>();
				for(Order o:oList){
					for(User u:ulist){
						if(o.getUser_id() == u.getUid()){
							if(u.getUname().indexOf(keyName) != -1){	//�ж��Ƿ�����û���ѯ�Ĺؼ���
								sList.add(o);
							}
						}
					}
					
					
				}
				
				
				session.setAttribute("olist", sList);
				session.setAttribute("orderNum", sList.size());
				session.setAttribute("ulist", ulist);

				//ҳ����ת
				req.getRequestDispatcher("/admin/order.jsp").forward(req, res);
				
			}
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("��ѯʧ�ܣ����������Ƿ���ȷ��");
			em.setFoxurl("/servlet/OrderAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
	}

}
