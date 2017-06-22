package UPS.DataAccess;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import UPS.Bean.productBean;

public class productDao {

		
		static Connection currentCon = null;
		static ResultSet rs = null;
		public static ArrayList <productBean> listS1;

		public static productBean prod(productBean prod) {
			// preparing some objects for connection
			System.out.println("JIJIJI");
			Statement stmt = null;
			
			String productid = prod.getproductid();
			String productprice = prod.getproductprice();
			String quantity = prod.getproductquantity();
			String bookid = prod.getbookid();
			String sleeve_text = prod.getsleeve_text();
			String back_text = prod.getback_text();
			String description = prod.getdescription();
			
			
			
			String createQuery = "INSERT INTO BOOKING_PRODUCT (productid, price, quantity, bookid, sleeve_text, back_text, description) "
					+ "values ('"+productid+"','"+productprice+"','"+quantity+"','"+bookid+"','"+sleeve_text+"','"+back_text+"','"+description+"')";
			
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
					prod.setValid(false);
					
				}
				// if user exists set the isValid variable to true
				else if (more) {
					prod.setValid(true);
					
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
			return prod;
		}
		
		public static String listProduct() {
	        Connection myCon;
	        Statement myStmt;

	        
	            try {
	                Class.forName("oracle.jdbc.OracleDriver").newInstance();

	                myCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",  "UPS", "faris");
	                myStmt = myCon.createStatement();

	                ResultSet result = myStmt.executeQuery("select * from product");
	                
	                listS1 = new ArrayList<productBean>();


	                while (result.next()) {
	                	productBean prod = new productBean();
	                	prod.setproductid(result.getString("productid"));
	                	prod.setproductname(result.getString("productname"));
	                	prod.setproductprice(result.getString("productprice"));
	                	prod.setproductquantity(result.getString("productquantity"));
	                	prod.setbookid(result.getString("bookid"));
	                	prod.setsleeve_text(result.getString("sleeve_text"));
	                	prod.setback_text(result.getString("back_text"));
	                	prod.setdescription(result.getString("description"));
	                	
	        			
	                
	                
	                listS1.add(prod);

	                }
	                result.close();
	                myCon.close();
	                return "success";

	            } catch (Exception sqlEx) {
	                return "" + sqlEx;

	                

	            }
	        }
	}



