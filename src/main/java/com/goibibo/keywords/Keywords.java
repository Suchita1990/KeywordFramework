package com.goibibo.keywords;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import com.keywordframework.goibibo.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	/** 
	 * This method is used to open browser in either of following "CHROME", "Firefox", Internet browser "IE", 
	 * "Opera","HTMLUnit", "Safari".
	 * @param browserName {@code String}
	 * @author Suchita
	 */
	 
	public static void openBrowser(String browserName) {
		
		switch (browserName) {
		case "Chrome":
			// System.setProperty("webdriver.chrome.driver", "E:\\Java
			// program\\JARs\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			Constants.driver = new OperaDriver();
			break;

		default:
			System.out.println("Invalid BrowserName Provided: " + browserName);
			break;
		}

	}
	/**This Method is used to open Url as specified in String.
	 * @param url{@code String}
	 * @author Suchita
	 */

	public static void openUrl(String url) {
		System.out.println(url+" is loading..");
		Constants.driver.get(url);

	}

	/*
	 * public static void navigate(String url) {
	 * Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * Constants.driver.get(url); }
	 */
	public static void maximizeWindow() {
		Constants.driver.manage().window().maximize();
	}
	/**This Method presented logo of the webpage.
	 * @author Suchita
	 * @return 
	 */

	public static String checkApproriatelogoDisplay(String locatorValue) {
		return Constants.driver.findElement(By.cssSelector(locatorValue)).getText();
	}

	public static void clickOnMainheader(String locatorValue) {
		Constants.driver.findElement(By.cssSelector(locatorValue)).isEnabled();

	}

	public static void checkSubMenuitemsPresentOnmainHeader(String locatorType, String locatorValue) {
		Constants.driver.findElement(By.xpath(locatorValue)).isDisplayed();

	}

	/**This method presents click on element action and perform action, back to parent window 
	 * as required with parameter locatorType {@code String}, locatorValue {@code String}. 
	 * This method is used for button, link and images so on..
	 * @param locatorType
	 * @param locatorValue
	 *
	 */
	/*public static void clickOnElement(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "NAME":
			Constants.driver.findElement(By.className(locatorValue)).click();
			break;
		case "CSS":
			Constants.driver.findElement(By.cssSelector(locatorValue)).click();
			break;
		case "ID":
			Constants.driver.findElement(By.id(locatorValue)).click();
			break;
		case "LINK_TEXT":
			Constants.driver.findElement(By.linkText(locatorValue)).click();
			break;
		case "XPATH":
			Constants.driver.findElement(By.xpath(locatorValue)).click();
			break;
		case "CLASSNAME":
			Constants.driver.findElement(By.className(locatorValue)).click();
			break;
		default:
			System.out.println("Invalid locatorType");
			break;
		}
	}
*/
	
	public static void takeScreenshotOfHalfPage() throws IOException {
		// Java class which formats date and time in a given manner
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();

		String fileName = (dateFormat.format(date)).toString();
		System.out.println(fileName);

		// Using below function TakesScreenshot which is type-casted to driver whose
		// output type is File.
		File sourceFile = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("Screenshots/HalfPageScreenShot/" + fileName);
		// Using copyFile function which take 2 parameters , sourceFile and destination
		// file( where you can provide the path with the file extension )
		// System.getProperty("user.dir") - provide the current directory path.
		// FileUtils.copyFile(sourceFile, new File(System.getProperty("E:\\Eclipse
		FileUtils.copyFile(sourceFile, new File("screenshots" + fileName + ".jpg"));
		// FileUtils.copyFile(sourceFile, dest);
		System.out.println("" + dest);
		
	}

	public static void takeAScreenshot(String testMethodName) {
		File imgSrc = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
		String timespan = new SimpleDateFormat("dd_MM_yy").format(new Date());
		String timespan1 = new SimpleDateFormat("ddMM_hhmm").format(new Date());
		File imgDest = new File(
				"E:\\Eclipse Workspace\\keywords\\Screeenshots\\" + timespan + "SC_" + "_" + timespan1 + ".png");
		try {
			FileUtils.copyFile(imgSrc, imgDest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/** This method is used to get specific web element as required with parameter locatorType {@code String}, 
	 * locatorval {@code String}. This webelement to perform different action.
	 *
	 * @param locatorType {@code String}
	 * @param locatorval {@code String}
	 * @return {@link WebElement}
	 * @author Suchita
	 */

	
	public static WebElement getWebelement(String locatorType, String locatorValue) {
		WebElement element=null;
		switch (locatorType) {
		case "CLASSNAME":
			element=Constants.driver.findElement(By.className(locatorValue));
			break;
		case "CSS":
			element=Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element=Constants.driver.findElement(By.id(locatorValue));
			break;
		case "LINK_TEXT":
			element=Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case "NAME":
			element=Constants.driver.findElement(By.name(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element=Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "TAG_NAME":
			element=Constants.driver.findElement(By.tagName(locatorValue));
			break;
		case "XPATH":
			element=Constants.driver.findElement(By.xpath(locatorValue));
			break;
			default:
			System.err.println("Invalid Locator Type to be selected : " + locatorType);
			break;
		}
		return element;
	}
	
	public static WebElement userProfiledetails(String locatorValue) {
		Constants.action = new Actions(Constants.driver);
		WebElement profile = Constants.driver.findElement(By.cssSelector(locatorValue));
		Constants.action.moveToElement(profile).build().perform();
		return profile;

	}
	/**This method perform action of mouse Hover On Element as required with parameter locatorType {@code String}, 
	 * @param locatorType
	 * 
	 * {@link Actions}
	 * @return 
	 */
		public static WebElement mouseHoverOnElement(String locatorValue) {
			//Create object 'action' of an Actions class
			Constants.action = new Actions(Constants.driver);
			WebElement items = Constants.driver.findElement(By.cssSelector(locatorValue));
			//Mouseover on an element
			//build() method is used to compile all the actions into a single step
			Constants.action.moveToElement(items).build().perform();
			return items;
	}

	
	/**
	 * This method is used to enter text if text-box is available.
	 * {@code SendKeys} for send text in text-box
	 * @param locatorType
	 * @param locatorval
	 * @param textvalue
	 */
	public static void enterText(String locatorType,String locatorValue, String textToEnter) {
		getWebelement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	
    public static void clickOnElement1(String locatorType, String locatorValue) {
       getWebelement(locatorType, locatorValue).click();
	}
    
    public void selectValuefromList(String locatorType, String locatorValue ,String textToSelect) {
       WebElement element=getWebelement(locatorType, locatorValue);
	}
	/**
	 * This method is used to close the browser which are open.
	 */
	public static void terminateBrowser() {
		Constants.driver.quit();
		
	}

	
}
