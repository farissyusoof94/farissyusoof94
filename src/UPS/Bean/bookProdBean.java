package UPS.Bean;

import UPS.DataAccess.bookProdDao;

public class bookProdBean {

			private String bookid;
			private String productid;
			private String quantity;
			private String price;
			private String sleeve_text;
			private String back_text;
			private String description;
			private String booking_product_id;
			public boolean valid;
			
			public String getbookid() {
				return bookid;
			}
			public void setbookid(String bookid) {
				this.bookid = bookid;
			}
			
			public String getproductid() {
				return productid;
			}
			public void setproductid(String productid) {
				this.productid = productid;
			}
			
			public String getquantity() {
				return quantity;
			}
			public void setquantity(String quantity) {
				this.quantity = quantity;
			}
			
			public String getback_text() {
				return back_text;
			}
			public void setback_text(String back_text) {
				this.back_text = back_text;
			}
			
			public String getsleeve_text() {
				return sleeve_text;
			}
			public void setsleeve_text(String sleeve_text) {
				this.sleeve_text = sleeve_text;
			}
			
			public String getprice() {
				return price;
			}
			public void setprice(String price) {
				this.price = price;
			}
			
			public String getdescription() {
				return description;
			}
			public void setdescription(String description) {
				this.description = description;
			}
			
			public String getbooking_product_id() {
				return booking_product_id;
			}
			public void setbooking_product_id(String booking_product_id) {
				this.booking_product_id = booking_product_id;
			}
			
			public boolean isValid() {
				return valid;
			}
			public void setValid(boolean valid) {
				this.valid = valid;
			}
			public static String listbookProd()
		    {
		        String a = bookProdDao.listbookProd();
		        return a;
		    }
			
			

			
		}



