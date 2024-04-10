package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtils {
	
	
	//TO READ PROPERTY PAGE
	public static String readProperty(String key) throws Exception{
		
		Properties pro = new Properties();
		String path=System.getProperty("user.dir")+"/src/main/resources/config.properties";
		FileInputStream fis = new FileInputStream(path);
		pro.load(fis);
		
		return pro.getProperty(key);
		
		
		
	}
/*	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir")+"/src/main/resources/config.properties");
	
	

	}*/

}
