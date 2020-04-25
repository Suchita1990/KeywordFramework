package com.signinpage.using_listener_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;
import com.keywordframework.goibibo.Constants;

public class UserDetails {
	@Test
	public void informationDetailsOfuser() {
		Keywords.openBrowser("Chrome");
		Constants.driver.get(Constants.baseUrl);
		Keywords.maximizeWindow();
		Keywords.userProfiledetails("#hd_user_widdget");
		Constants.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Keywords.terminateBrowser();
	}
	@Test(dependsOnMethods="informationDetailsOfuser")
	public void VerifyMenuItems()
	{
	  String[] expectedSubNavItems= {"My Trips","View Ticket","Cancel Ticket","Make Payment","Check Refund Status","Write to us"};
	  Keywords.openBrowser("Chrome");
	  Constants.driver.get(Constants.baseUrl);
	  WebElement subNavItems= Constants.driver.findElement(By.cssSelector("#hd_user_widdget"));
	  ArrayList actualsubNavItems=new ArrayList<String>();
	   Iterator<WebElement> itr=((ArrayList) subNavItems).iterator();
	   while (itr.hasNext())
	   {
		actualsubNavItems.add(itr.next().getText());
       }
	   for (String item : expectedSubNavItems) 
		   {
			 Assert.assertTrue(actualsubNavItems.contains(item));
		   }
	   Keywords.terminateBrowser();
	}

}
