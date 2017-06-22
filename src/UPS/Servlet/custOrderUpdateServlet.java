package UPS.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UPS.Bean.customerBean;
import UPS.Bean.createOrder;
import UPS.DataAccess.custOrderUpdateDao;

/**
 * Servlet implementation class OwnerUpdateServlet
 */
//@WebServlet("/custOrderUpdateServlet")
public class custOrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			customerBean custUpdate = new customerBean();
			custUpdate.setcustid(request.getParameter("customerid"));
			custUpdate.setcustname(request.getParameter("customername"));
			custUpdate.setcustaddress(request.getParameter("customeraddress"));
			custUpdate.setcustphoneno(request.getParameter("customerphoneno"));
			custUpdate.setcustemail(request.getParameter("customeremail"));
			
			createOrder bookUpdate = new createOrder();
			bookUpdate.setbookid(request.getParameter("bookid"));
			bookUpdate.setbookdate(request.getParameter("bookdate"));
			bookUpdate.setcollectdate(request.getParameter("collectdate"));
			
			
			
			
			custUpdate = custOrderUpdateDao.cust(custUpdate, bookUpdate);
			

			if (custUpdate.isValid())
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionCustomer", custUpdate);
				response.sendRedirect("customerdetails.jsp");
			}
			else
				response.sendRedirect("home.jsp");
			
			
			
			
		}
		catch (Throwable theException)
		{
			System.out.println(theException);
		}
	}	
		
	
}

