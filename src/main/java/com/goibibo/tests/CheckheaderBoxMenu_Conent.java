package com.goibibo.tests;

import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;

public class CheckheaderBoxMenu_Conent {

	@Test
	public void openhomepage() {
		Keywords.openBrowser("Chrome");
		Keywords.openUrl("https://www.goibibo.com/");
		Keywords.maximizeWindow();
	}
	@Test
	public void verifymainHeader_Display() {
	//	Keywords.clickOnMainheader("#header");
		Keywords.clickOnElement1("CSS", "#header");
		System.out.println("main-header enabled");
	}
	@Test
    public void verifyHeadersubMenu() {
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='Flights']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='Hotels'][position()='1']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='Hotels']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='Bus']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='IRCTC Trains']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='Cabs']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//span[text()='Visa']");
       Keywords.checkSubMenuitemsPresentOnmainHeader("XPATH", "//div[@class='padB10 lh1-2 iconText fmtTooltip']");
       System.out.println("All Header sub-menu items displayed");

  }
	
	@Test
	public void verifycustomerSupportlink() {
		Keywords.clickOnElement1("XPATH", "//span[text()=' 24x7 goCare Support']");
		System.out.println("24*7 goCare Support link is Displayed on Header");

	}
}
