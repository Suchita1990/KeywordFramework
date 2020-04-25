package com.testcasefailure.screenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.keywordframework.goibibo.Constants;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakefullPageScreenShot {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Java program\\JARs\\chromedriver.exe");
		Constants.driver = new ChromeDriver();

		Constants.driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000));

		// BufferedImage
		// img=ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(driver).getImage();

		Screenshot sc = ashot.takeScreenshot(Constants.driver);
		BufferedImage img = sc.getImage();
		Date date = new Date();
		String s=date.toString();
		s=s.replaceAll("\\:", "");
        ImageIO.write(img, "PNG", new File("./Capture/"+s+".png"));
	   
	}

}
