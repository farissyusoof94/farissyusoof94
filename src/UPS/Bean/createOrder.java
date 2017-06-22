package UPS.Bean;

import UPS.DataAccess.orderDao;

public class createOrder {

		private String bookid;
		private String bookdate;
		private String collectdate;
		private String custid;
		private String staffid;
		public boolean valid;
		
		public String getbookid() {
			return bookid;
		}
		public void setbookid(String bookid) {
			this.bookid = bookid;
		}
		public String getbookdate() {
			return bookdate;
		}
		public void setbookdate(String bookdate) {
			this.bookdate = bookdate;
		}
		public String getcollectdate() {
			return collectdate;
		}
		public void setcollectdate(String collectdate) {
			this.collectdate = collectdate;
		}
		
		public String getcustid() {
			return custid;
		}
		public void setcustid(String custid) {
			this.custid = custid;
		}
		
		public String getstaffid() {
			return staffid;
		}
		public void setstaffid(String staffid) {
			this.staffid = staffid;
		}
		
		public boolean isValid() {
			return valid;
		}
		public void setValid(boolean valid) {
			this.valid = valid;
		}
		public static String listOrder()
	    {
	        String a = orderDao.listOrder();
	        return a;
	    }
		
		

		
	}


