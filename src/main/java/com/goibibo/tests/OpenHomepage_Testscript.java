package com.goibibo.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Connection.Method;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;
import com.keywordframework.goibibo.Constants;
import com.utilities.Log;

import junit.framework.Assert;

public class OpenHomepage_Testscript {
	/*
	 * @BeforeTest public void loadLog4j() { String log4Jpath=System.
	 * getProperty("E:\\Eclipse Workspace\\keywords\\src\\main\\resources\\log4j.properties"
	 * ) +"/log4j.properties"; PropertyConfigurator.configure(log4Jpath); }
	 */

	@Test(description = "VerifyBrowser : Chrome")
	public void openhomepage() {
		Log.info("******************* Starting test cases execution **********************");
		Keywords.openBrowser("Chrome");
		Log.info("Browser Open");
		// Keywords.openUrl("https://www.goibibo.com/");
		Constants.driver.get(Constants.baseUrl);
		Log.info("Opening required url");
		Keywords.maximizeWindow();
        Log.info("Maiximize Window");
	}

	@Test
	public void verifyLogo() {
		Log.startLog("Test case start for logo");
		String expectedTitle = "goibibo.com";
    	String actualTitle = Keywords.checkApproriatelogoDisplay("a.hdrLogo>img");
		Assert.assertEquals(expectedTitle, actualTitle);
		Log.info("Comparing two strings");
		Keywords.terminateBrowser();
		Log.info("Terminating Browser");
	}
}
