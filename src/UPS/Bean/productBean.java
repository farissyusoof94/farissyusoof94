package UPS.Bean;

import UPS.DataAccess.productDao;

public class productBean {

	
		private String productid;
		private String productname;
		private String productprice;
		private String productquantity;
		private String bookid;
		private String sleeve_text;
		private String back_text;
		private String description;
		public boolean valid;
		public String getproductid() {
			return productid;
		}
		public void setproductid(String productid) {
			this.productid = productid;
		}
		public String getproductname() {
			return productname;
		}
		public void setproductname(String productname) {
			this.productname = productname;
		}
		public String getproductprice() {
			return productprice;
		}
		public void setproductprice(String productprice) {
			this.productprice = productprice;
		}
		public String getproductquantity() {
			return productquantity;
		}
		public void setproductquantity(String productquantity) {
			this.productquantity = productquantity;
		}
		public String getbookid() {
			return bookid;
		}
		public void setbookid(String bookid) {
			this.bookid = bookid;
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
		
		public String getdescription() {
			return description;
		}
		public void setdescription(String description) {
			this.description = description;
		}
		
		public boolean isValid() {
			return valid;
		}
		public void setValid(boolean valid) {
			this.valid = valid;
		}
		public static String listProduct()
	    {
	        String a = productDao.listProduct();
	        return a;
	    }
		
		

		
	}


