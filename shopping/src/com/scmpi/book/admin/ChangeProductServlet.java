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
		p.setPid(Integer.valueOf(req.getParameter("pid").trim()));
		p.setPname(req.getParameter("pname").trim());
		p.setPclassifyid(req.getParameter("pclassifyid").trim());
		p.setPdate(req.getParameter("pdate").trim());
		p.setSuppliers(req.getParameter("suppliers").trim());
		p.setPnumber(Integer.valueOf(req.getParameter("pnumber").trim()));
		p.setPrice(Float.valueOf(req.getParameter("price").trim()));
		p.setDescw(req.getParameter("descw").trim());
		p.setImg(req.getParameter("img").trim());
		
		
		try {
			ps.updateProduct(p);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("�޸�ʧ��");
			em.setFoxurl("/shopping/servlet/ProductAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/shopping/error.jsp").forward(req, res);
		}
		
		
		//ҳ����ת
		req.getRequestDispatcher("/shopping/servlet/ProductAdminServlet").forward(req, res);
		
		
		
		
	}

}
