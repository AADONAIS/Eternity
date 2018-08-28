package cn.supermarket.manager.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private static String driver;
    private static String url;
    private static String username;
    private static String password;
	
	static {
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream("./db.properties"));
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	public static  Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password); 
	}
}
