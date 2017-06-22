package UPS.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UPS.Bean.createOrder;
import UPS.DataAccess.orderDao;


/**
 * Servlet implementation class PetRegisterServlet
 */
//@WebServlet("/createOrderServlet")
public class createOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			createOrder order = new createOrder();
			order.setbookdate(request.getParameter("bookdate"));
			order.setcollectdate(request.getParameter("collectdate"));
			order.setcustid(request.getParameter("custid"));
			order.setbookid(request.getParameter("bookid"));
			order.setstaffid(request.getParameter("staffid"));
			
			order = orderDao.order(order);
			
			if (order.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionOrder", order);
				
				response.sendRedirect("ProductList.jsp"); // logged-in page
			} else
				response.sendRedirect("home.jsp"); // error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
