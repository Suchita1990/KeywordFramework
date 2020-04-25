package com.signinpage.using_listener_demo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;
import com.keywordframework.goibibo.Constants;

public class SignInwithCredential {
	@Test(priority = 1)
	public void signInwithValid_mobileNumber() throws InterruptedException {

		Keywords.openBrowser("Chrome");
		// Keywords.openUrl("https://www.goibibo.com/");
		Constants.driver.get(Constants.baseUrl);
		Keywords.maximizeWindow();
	
		Keywords.clickOnElement1("CSS", "#get_sign_in");
		Constants.driver.switchTo().frame("authiframe");
		Thread.sleep(4000);
		Keywords.clickOnElement1("CSS", "input#authMobile.form-control.placeholder");
		Keywords.clickOnElement1("input#authMobile", "9890022239");
		Keywords.clickOnElement1("CSS", "#mobileSubmitBtn");
		Thread.sleep(4000);
		Keywords.terminateBrowser();
	}

	@Test(priority = 2)
	public void loginWithfacebook() {

		Keywords.openBrowser("Chrome");
		Keywords.openUrl("https://www.goibibo.com/");
		Keywords.maximizeWindow();

		Keywords.clickOnElement1("CSS", "#get_sign_in");
		Constants.driver.switchTo().frame("authiframe");
		Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Keywords.clickOnElement1("CSS", "#authFBSignInBtn");

		Keywords.terminateBrowser();

	}

}
