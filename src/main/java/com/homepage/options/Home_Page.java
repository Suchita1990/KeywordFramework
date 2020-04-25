package com.homepage.options;

import static org.testng.Assert.assertTrue;
import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;
import com.keywordframework.goibibo.Constants;
import com.utilities.Log;

public class Home_Page {
	@Test
	public void titileOfHomepage() {
		Log.info("*****************Test Start***********************************");
		Keywords.openBrowser("Chrome");
		Log.info("**********Chrome Browser Open With Specified Url**************");
		Constants.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String Expected_Title = "Domestic And International Flights";
		String Actual_Title = " ";
		Constants.driver.get(Constants.baseUrl);
		Keywords.maximizeWindow();
		Actual_Title = Constants.driver.getTitle();
		if (Actual_Title.equals(Expected_Title))
		{
		System.out.println( "Test Passed") ;
		}
		else {
		System.out.println( "Test Failed" );
		}
		Constants.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//close browser
	//	Keywords.terminateBrowser();
	}
	@Test
	public void displayNavbarmenuItems() {
		Constants.action.moveToElement(Constants.driver.findElement(By.cssSelector("span#oneway.curPointFlt.switchAct"))).click().build().perform();
	}
}


