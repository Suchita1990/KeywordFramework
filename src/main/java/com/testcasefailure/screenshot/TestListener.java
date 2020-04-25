package com.testcasefailure.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	WebDriver driver=null;
	String filePath = "D:\\SCREENSHOTS";

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String timestamp=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
       WebDriver driver = (WebDriver)context.getAttribute("driver");
    	takeScreenShot(timestamp, driver);		
	}
	  public void takeScreenShot(String methodName, WebDriver driver) {
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try {
	            	
					FileUtils.copyFile(scrFile, new File("filePath/screenshot_"+timestamp()+".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }

	public String timestamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
