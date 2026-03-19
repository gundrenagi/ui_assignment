package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.DriverFactory;

public class ScreenshotUtil {

	   public static void capture(String testName) {
	        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        File dest = new File("screenshots/" + testName + ".png");
	        try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
