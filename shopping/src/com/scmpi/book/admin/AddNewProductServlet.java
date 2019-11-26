package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.dao.ProductDao;
import com.scmpi.book.dao.impl.ProductDaoImpl;
import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Product;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class AddNewProductServlet extends HttpServlet {

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
			Product p =new Product();
			p.setPname(req.getParameter("pname").toString());
			p.setPclassifyid(req.getParameter("pclassifyid"));
			p.setPdate(req.getParameter("pdate"));
			p.setSuppliers(req.getParameter("suppliers"));
			p.setPnumber(Integer.valueOf(req.getParameter("pnumber")));
			p.setPrice(Float.parseFloat(req.getParameter("price")));
			p.setDescw(req.getParameter("descw"));
			p.setImg(req.getParameter("img"));
		
		
		
			if(p.getPname() == "" || p.getImg()== "" || p.getPdate()== "" || p.getDescw()== "" || p.getPnumber() == 0 || p.getPrice() == 0){
				
				ErrorMsg em = new ErrorMsg();
				em.setMsg("����ʧ�ܣ����������Ƿ���ȷ��");
				em.setFoxurl("/servlet/ProductAdminServlet");
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
			}else{
				ProductDao pd = new ProductDaoImpl();
				
				pd.insert(p);

				//ҳ����ת
				req.getRequestDispatcher("/servlet/ProductAdminServlet").forward(req, res);
				
			}
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("����ʧ�ܣ����������Ƿ���ȷ��");
			em.setFoxurl("/shopping/servlet/ProductAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/shopping/error.jsp").forward(req, res);
		}
		
		
		
		
		
		
	}
}