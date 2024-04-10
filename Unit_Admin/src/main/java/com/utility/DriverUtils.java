package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import com.base.BaseClass;

public class DriverUtils extends BaseClass {
	
	
	public static String captureScreenshot(String name)  {
		
		//driver came from BaseClass So it has To Extend from BaseClass
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
	    File file=	ts.getScreenshotAs(OutputType.FILE);
	    
	//  String path=System.getProperty("user.dir")+"/order_calalogue/Customer_Orders/Screenshort"+name+".png";
	   String path="C:\\Users\\radhe\\git\\order_calalogue\\Customer_Orders\\Screenshort"+name+".png";
	   
	   try {
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
			return path;
	}

}
