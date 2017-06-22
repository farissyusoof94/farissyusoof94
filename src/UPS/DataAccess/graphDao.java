package UPS.DataAccess;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import UPS.Bean.createOrder;
import UPS.Bean.graph;

public class graphDao {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static ArrayList <graph> listS1;

	public static graph graph(graph graph) {
		// preparing some objects for connection
		System.out.println("JIJIJI");
	return graph;
	}
	
    public static String listOrder() {
        Connection myCon;
        Statement myStmt; 
    try {
    	Class.forName("oracle.jdbc.OracleDriver").newInstance();
    	DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
        myCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",  "UPS", "faris");
        myStmt = myCon.createStatement();
            ResultSet query_set = myStmt.executeQuery("SELECT  PRODUCTID, SUM (QUANTITY) as myquantity from BOOKING_PRODUCT GROUP BY PRODUCTID");
         // connect to DB 
            listS1 = new ArrayList<graph>();
            
            
            while (query_set.next()) {
                String product = query_set.getString("PRODUCTID");
                int quantity = query_set.getInt("myquantity");
                my_bar_chart_dataset.addValue(quantity,"Mark",product);
                }
        	
            	
        myCon.close();
        return "success";

    } catch (Exception sqlEx) {
        return "" + sqlEx;

        

    }     	
    
}
	}
