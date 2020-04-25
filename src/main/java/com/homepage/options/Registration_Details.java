package com.homepage.options;

import org.testng.annotations.Test;

import com.goibibo.keywords.Keywords;
import com.utilities.Log;

public class Registration_Details {
	@Test(description="VerifyTextBoxLabel : for src textbox")
	public void verifyTextBox() {
		Log.info("**************** VerifyTextBoxLabel : for src textbox ***************");
		Keywords.openBrowser("Chrome");
		Keywords.openUrl("https://www.goibibo.com/");
		Keywords.maximizeWindow();
		Keywords.clickOnElement1("CSS", "gosuggest_inputSrc");
		Keywords.enterText("CSS", "gosuggest_inputSrc", "Pune");
	}

}
