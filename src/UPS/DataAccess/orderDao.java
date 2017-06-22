package UPS.DataAccess;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//import veterinary.clinicfamily.bean.MedicineBean;
import UPS.Bean.createOrder;


public class orderDao {
	
		static Connection currentCon = null;
		static ResultSet rs = null;
		public static ArrayList <createOrder> listS1;

		public static createOrder order(createOrder order) {
			// preparing some objects for connection
			System.out.println("JIJIJI");
			Statement stmt = null;
			
			String bookid = order.getbookid();
			String bookdate = order.getbookdate();
			String collectdate = order.getcollectdate();
			String custid = order.getcustid();
			String staffid = order.getstaffid();
			
			
			
			String createQuery = "INSERT INTO BOOKING (bookid, bookdate, collectdate, customerid, staffid) "
					+ "values ('"+bookid+"', to_date('" +bookdate+"','yyyy-mm-dd'),to_date('" +collectdate+"','yyyy-mm-dd'),'"+custid+"','"+staffid+"')";
			
			// "System.out.println" prints in the console; Normally used to trace
			// the process
			
			System.out.println("Query: " + createQuery);
			try {
				// connect to DB
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(createQuery);
				boolean more = rs.next();
				// if user does not exist set the isValid variable to false
				if (!more) {
					System.out
							.println("Sorry, you have entered invalid value");
					order.setValid(false);
					
				}
				// if user exists set the isValid variable to true
				else if (more) {
					order.setValid(true);
					
				}
			} catch (Exception ex) {
				System.out.println("Log In failed: An Exception has occurred! "
						+ ex);
			}
			// some exception handling
			finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
					}
					rs = null;
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
					}
					stmt = null;
				}
				if (currentCon != null) {
					try {
						currentCon.close();
					} catch (Exception e) {
					}
					currentCon = null;
				}
			}
			return order;
		}
		
		public static String listOrder() {
	        Connection myCon;
	        Statement myStmt;

	        
	            try {
	                Class.forName("oracle.jdbc.OracleDriver").newInstance();

	                myCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",  "UPS", "faris");
	                myStmt = myCon.createStatement();

	                ResultSet result = myStmt.executeQuery("select * from booking");
	                
	                listS1 = new ArrayList<createOrder>();


	                while (result.next()) {
	                	createOrder order = new createOrder();
	                	order.setbookid(result.getString("bookid"));
	                	order.setbookdate(result.getString("bookdate"));
	                	order.setcollectdate(result.getString("collectdate"));
	        			order.setcustid(result.getString("custid"));
	                
	                
	                listS1.add(order);

	                }
	                result.close();
	                myCon.close();
	                return "success";

	            } catch (Exception sqlEx) {
	                return "" + sqlEx;

	                

	            }
	        }
	}



