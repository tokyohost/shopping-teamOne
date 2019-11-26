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

import com.scmpi.book.dao.ProductDao;
import com.scmpi.book.dao.impl.ProductDaoImpl;
import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class SearchProductServlet extends HttpServlet {

	/**
	 * ��̨��Ʒ����
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
				em.setFoxurl("/servlet/ProductAdminServlet");
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
			}else{
				ProductDao pd = new ProductDaoImpl();
				
				List<Product> pList= pd.queryAll();	//��ѯ���е���Ʒ
				List<Product> sList = new ArrayList<Product>();
				for(Product p:pList){
					if(p.getPname().indexOf(keyName) != -1){	//�ж��Ƿ�����û���ѯ�Ĺؼ���
						sList.add(p);
					}
					
				}
				
				//��ȡ��Ʒ����
				List<ProductType> ptype = ps.getProductTypes();
				session.setAttribute("plist", sList);
				session.setAttribute("ptype", ptype);

				//ҳ����ת
				req.getRequestDispatcher("/admin/product.jsp").forward(req, res);
				
			}
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("��ѯʧ�ܣ����������Ƿ���ȷ��");
			em.setFoxurl("/servlet/ProductAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
		
		
		
		
		
		
	}
}
