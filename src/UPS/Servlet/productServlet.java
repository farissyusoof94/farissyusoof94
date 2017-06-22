package UPS.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UPS.Bean.productBean;
import UPS.DataAccess.productDao;


/**
 * Servlet implementation class PetRegisterServlet
 */
//@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			productBean prod = new productBean();
			prod.setbookid(request.getParameter("bookid"));
			prod.setproductid(request.getParameter("productid"));
			prod.setproductname(request.getParameter("productname"));
			prod.setproductprice(request.getParameter("productprice"));
			prod.setproductquantity(request.getParameter("quantity"));
			prod.setsleeve_text(request.getParameter("sleeve_text"));
			prod.setback_text(request.getParameter("back_text"));
			prod.setdescription(request.getParameter("description"));
			
			
			prod = productDao.prod(prod);
			
			if (prod.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionProduct", prod);
				
				response.sendRedirect("customerdetails.jsp"); // logged-in page
			} else
				response.sendRedirect("home.jsp"); // error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
