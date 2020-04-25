package com.signinpage.using_listener_demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;
import com.keywordframework.goibibo.Constants;

//@Listeners(listener_demo.ListenerTest.class)
@Listeners(com.signinpage.using_listener_demo.ListenerTest.class)

public class SignIn_testCases {
	@Test
	public void Login() throws IOException {
		Keywords.openBrowser("Chrome");
		Keywords.openUrl("https://www.goibibo.com/");
		Keywords.maximizeWindow();
		Keywords.clickOnElement1("CSS", "#get_sign_in");
		Keywords.takeScreenshotOfHalfPage();
	}

	@Test
	public void TestToFail() throws IOException {
		System.out.println("This method to test fail");
		Assert.assertTrue(false);
		// Keywords.takeScreenshotOfHalfPage();
		//Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
