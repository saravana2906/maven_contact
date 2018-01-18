package com.contacts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import com.contacts.util.PropertiesUtil;

public class DatabaseUtil {
	private static Connection con;
	
	public static Connection getConnection()
	{
		String driver,url,username,password="";
		Properties appProperties=PropertiesUtil.getappProperties();
		driver=appProperties.getProperty("database_driver");
		url=appProperties.getProperty("database_url");
		username=appProperties.getProperty("database_user");
		password=appProperties.getProperty("database_pass");
	System.out.println(appProperties.getProperty("database_driver")+" "+
		appProperties.getProperty("database_url")+" "+
		appProperties.getProperty("database_user")+" "+
		appProperties.getProperty("database_pass"));
		try {  
			Class.forName(driver);  
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
