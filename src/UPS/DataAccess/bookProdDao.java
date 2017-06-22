package UPS.DataAccess;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//import veterinary.clinicfamily.bean.MedicineBean;
import UPS.Bean.bookProdBean;

public class bookProdDao {

		
			static Connection currentCon = null;
			static ResultSet rs = null;
			public static ArrayList <bookProdBean> listS1;

			public static bookProdBean bookProd(bookProdBean bookProd) {
				// preparing some objects for connection
				System.out.println("JIJIJI");
				Statement stmt = null;
				
				String bookid = bookProd.getbookid();
				String productid = bookProd.getproductid();
				String quantity = bookProd.getquantity();
				String price = bookProd.getprice();
				String sleeve_text = bookProd.getsleeve_text();
				String back_text = bookProd.getback_text();
				String description = bookProd.getdescription();
				String booking_product_id = bookProd.getbooking_product_id();
				
				
				
				String createQuery = "INSERT INTO BOOKING_PRODUCT (bookid, productid, quantity, price, booking_product_id, sleeve_text, back_text, description) "
						+ "values ('"+bookid+"','" +productid+"','" +quantity+"','" +price+"','"+booking_product_id+"','"+sleeve_text+"','"+back_text+"','"+description+"')";
				
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
						bookProd.setValid(false);
						
					}
					// if user exists set the isValid variable to true
					else if (more) {
						bookProd.setValid(true);
						
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
				return bookProd;
			}
			
			public static String listbookProd() {
		        Connection myCon;
		        Statement myStmt;

		        
		            try {
		                Class.forName("oracle.jdbc.OracleDriver").newInstance();

		                myCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",  "UPS", "faris");
		                myStmt = myCon.createStatement();

		                ResultSet result = myStmt.executeQuery("select * from booking_product");
		                
		                listS1 = new ArrayList<bookProdBean>();


		                while (result.next()) {
		                	bookProdBean bookProd = new bookProdBean();
		                	bookProd.setproductid(result.getString("productid"));
		                	bookProd.setquantity(result.getString("quantity"));
		                	bookProd.setprice(result.getString("price"));
		                	bookProd.setprice(result.getString("sleeve_text"));
		                	bookProd.setprice(result.getString("back_text"));
		                	bookProd.setprice(result.getString("description"));
		                	bookProd.setbooking_product_id(result.getString("booking_product_id"));
		                
		                
		                listS1.add(bookProd);

		                }
		                result.close();
		                myCon.close();
		                return "success";

		            } catch (Exception sqlEx) {
		                return "" + sqlEx;

		                

		            }
		        }
		}



