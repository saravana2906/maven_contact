package com.contacts.util;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	private static Properties appProperties;
	
	
	public static Properties getappProperties()
	{
		try
		{
		if(appProperties==null){
			
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("application.properties");
		appProperties = new Properties();
			appProperties.load(input);
		}
				
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return appProperties;
		
	}

}
