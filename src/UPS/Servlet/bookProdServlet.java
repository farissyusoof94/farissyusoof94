package UPS.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UPS.Bean.bookProdBean;
import UPS.DataAccess.bookProdDao;


/**
 * Servlet implementation class PetRegisterServlet
 */
@WebServlet("/bookProdServlet")
public class bookProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			bookProdBean bookProd = new bookProdBean();
			bookProd.setproductid(request.getParameter("productid"));
			bookProd.setquantity(request.getParameter("quantity"));
			bookProd.setprice(request.getParameter("price"));
			bookProd.setbookid(request.getParameter("bookid"));
			bookProd.setbookid(request.getParameter("sleeve_text"));
			bookProd.setbookid(request.getParameter("back_text"));
			bookProd.setbookid(request.getParameter("description"));
			bookProd.setbooking_product_id(request.getParameter("booking_product_id"));
			
			bookProd = bookProdDao.bookProd(bookProd);
			
			if (bookProd.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionBookProd", bookProd);
				
				response.sendRedirect("viewOrder.jsp"); // logged-in page
			} else
				response.sendRedirect("home.jsp"); // error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
