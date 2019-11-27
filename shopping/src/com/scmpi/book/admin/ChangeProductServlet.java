package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class ChangeProductServlet extends HttpServlet {

	/*
	 * ��̨��Ʒ��Ϣ�޸�
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
		
		Product p =new Product();
		p.setPid(Integer.valueOf(req.getParameter("pid")));
		p.setPname(req.getParameter("pname").toString());
		p.setPclassifyid(req.getParameter("pclassifyid"));
		p.setPdate(req.getParameter("pdate"));
		p.setSuppliers(req.getParameter("suppliers"));
		p.setPnumber(Integer.valueOf(req.getParameter("pnumber")));
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		p.setDescw(req.getParameter("descw"));
		p.setImg(req.getParameter("img"));
		
		
		
		
		try {
			ps.updateProduct(p);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("�޸�ʧ��");
			em.setFoxurl("/servlet/ProductAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
		
		
		//ҳ����ת
		req.getRequestDispatcher("/servlet/ProductAdminServlet").forward(req, res);
		
		
		
		
	}

}
