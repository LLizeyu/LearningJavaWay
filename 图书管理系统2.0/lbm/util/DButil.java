package lbm.util;

import java.sql.*;
/**
 * 
 * @author 2017060105017 李泽宇
  * 连接数据库
 */
public class DButil {
	private static final String URL= "jdbc:sqlserver://localhost:1433;DatabaseName=Library_brms";
	private static final String NAME = "sa";
	private static final String PASSWORD = "mimimi123";
	private static Connection conn = null;

	static{
	        try {
	        	//加载驱动
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            // 获取数据库连接
	            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 // 对外提供一个方法获取数据库连接    
	 public static Connection getConnection(){     
		 return conn;	   
	 }
}
	
