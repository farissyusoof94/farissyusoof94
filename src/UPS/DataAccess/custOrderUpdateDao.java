package UPS.DataAccess;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;

import UPS.Bean.customerBean;
import UPS.Bean.createOrder;

public class custOrderUpdateDao {

		static Connection currentCon = null;
		static ResultSet rs=null;
		

		public static customerBean cust(customerBean cust, createOrder book) {
			// preparing some objects for connection
			System.out.println("lalalaa");
			Statement stmt = null;	
			Statement stmt1 = null;	
			Statement stmt2 = null;	
			Statement stmt3 = null;	
			
			String custid = cust.getcustid();
			String custname = cust.getcustname();
			String custaddress = cust.getcustaddress();
			String custphoneno = cust.getcustphoneno();
			String custemail = cust.getcustemail();
			
			String bookid = book.getbookid();
			String bookdate = book.getbookdate();
			String collectdate = book.getcollectdate();
			
			
		
			String updateQuery ="update customer set customername='"+custname+"',customeraddress='"+custaddress+"',customerphoneno='"+custphoneno+"',customeremail='"+custemail+"' where customerid = '" +custid+ "'";
			String updateQuery1=" select * from customer  where customerid='"+custid+"'";
			String updateQuery2 ="update booking set collectdate = '"+collectdate+"' where bookid = '" +bookid+ "'"; 	
			String updateQuery3=" select * from booking  where bookid='"+bookid+"'";
			
			
			
			// "System.out.println" prints in the console; Normally used to trace
			// the process
			System.out.println("Customer id" +custid);
			System.out.println("Customer name " + custname);
			System.out.println("Query: " + updateQuery);
			System.out.println("Query: " + updateQuery1);
			System.out.println("Query: " + updateQuery2);
			System.out.println("Query2: " + updateQuery3);
			
			try {
				// connect to DB
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				stmt1 = currentCon.createStatement();
				stmt2 = currentCon.createStatement();
				stmt3 = currentCon.createStatement();
				rs = stmt.executeQuery(updateQuery);
				rs = stmt1.executeQuery(updateQuery1);
				rs = stmt2.executeQuery(updateQuery2);
				rs = stmt3.executeQuery(updateQuery3);
				
				boolean more= rs.next();
				
				if(!more)
				{
					System.out.println("Sorry, you have entered invalid value");
					cust.setValid(false);
				}
				else if(more)
				{
					cust.setValid(true);
				}
			} 
			catch (Exception ex) {
				System.out.println("Log In failed: An Exception has occurred! "
						+ ex);
			}
			
			finally { 
				if (rs != null) { 
					try { 
						rs.close(); 
						} 
					catch (Exception e) { } rs = null; 
					}
				if (stmt != null) { 
						try { stmt.close(); 
						} 
						catch (Exception e) { 
							
						} stmt = null; 
						} 
				if (currentCon != null) { 
					try { 
						currentCon.close(); 
						} catch (Exception e) { 
							
						}currentCon = null; 
						} 
				} return cust; 
				}
			}


