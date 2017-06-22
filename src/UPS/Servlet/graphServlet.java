package UPS.Servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import chart.first;
import UPS.DataAccess.ConnectionManager;

/**
 * Servlet implementation class graphServlet
 */
//@WebServlet("/graphServlet")
public class graphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public static void main (String[] args) throws Exception,  IOException{
	       
		  
		   
         Class.forName ("oracle.jdbc.OracleDriver"); 
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "UPS", "faris");
         DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
         Statement stmt = conn.createStatement();
         Image image1 = null;
         try {
                 ResultSet query_set = stmt.executeQuery("SELECT BOOKING_PRODUCT.PRODUCTID, PRODUCT.PRODUCTNAME, SUM(BOOKING_PRODUCT.QUANTITY) AS MYQUANTITY FROM BOOKING INNER JOIN BOOKING_PRODUCT ON BOOKING_PRODUCT.BOOKID=BOOKING.BOOKID INNER JOIN PRODUCT ON PRODUCT.PRODUCTID=BOOKING_PRODUCT.PRODUCTID WHERE BOOKING.BOOKDATE LIKE '%-16' GROUP BY BOOKING_PRODUCT.PRODUCTID, PRODUCT.PRODUCTNAME");
                 while (query_set.next()) {
                         String product = query_set.getString("PRODUCTNAME");
                         int quantity = query_set.getInt("MYQUANTITY");
                         my_bar_chart_dataset.addValue(quantity,"PRODUCT NAME",product);
                         }
         JFreeChart BarChartObject=ChartFactory.createBarChart("Product Name VS Total Order Quantity - In 2016","Product Name","Total Order Quantity",my_bar_chart_dataset,PlotOrientation.VERTICAL,true,true,false);                  
         query_set.close();
         stmt.close(); 
         conn.close();
         int width=640; /* Width of the image */
         int height=480; /* Height of the image */  
         BufferedImage image = null;
       
        
         File BarChart=new File("C:\\Users\\faris yusof\\workspace\\UPS1\\WebContent\\images\\1.png");
         ChartUtilities.saveChartAsPNG(BarChart,BarChartObject,width,height); 
         image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
         image1 = ImageIO.read(BarChart);
         }
          catch (Exception i){
     	i.printStackTrace();
     }

     JFrame frame = new JFrame();
     frame.setSize(800, 700);
     JLabel label = new JLabel(new ImageIcon(image1));
     frame.add(label);
     frame.setVisible(true);
 }
 }
