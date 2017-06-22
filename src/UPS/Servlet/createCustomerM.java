package UPS.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import UPS.Bean.customerBean;
import UPS.DataAccess.createCustomerDao;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/createCustomerM")
public class createCustomerM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			customerBean cust = new customerBean();
			cust.setcustid(request.getParameter("custid"));
			cust.setcustname(request.getParameter("custname"));
			cust.setcustaddress(request.getParameter("custaddress"));
			cust.setcustphoneno(request.getParameter("custphoneno"));
			cust.setcustemail(request.getParameter("custemail"));
			cust.setstaffId(request.getParameter("staffId"));
			
			
			cust = createCustomerDao.insert(cust);
			
			if (cust.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionCustomer", cust);
				
				response.sendRedirect("createOrder(M).jsp"); // logged-in page
			} else
				response.sendRedirect("homeManager.jsp"); // error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}