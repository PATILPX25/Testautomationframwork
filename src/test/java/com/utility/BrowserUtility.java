package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BrowserUtility {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility(String browserName)
	{
		if(browserName.equals("chrome"))
		{

	        WebDriverManager.chromedriver().setup(); // auto-downloads & configures
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
	}
	
	public BrowserUtility(Browser browserName)
	{
		if(browserName == Browser.chrome)
		{
			driver = new ChromeDriver();
		}
		else if(browserName == Browser.edge)
		{
			driver = new EdgeDriver();
		}
		else if(browserName == Browser.firefox)
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
	}

	public void goToWebside(String url) {
		driver.get(url);
	}

	public void maxWindow() {
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	public void enterText(By locator, String txt) {
		WebElement textBox = driver.findElement(locator);
		textBox.sendKeys(txt);
	}

	public String getVisiableText(By locator) {
		WebElement username = driver.findElement(locator);
		return username.getText();
	}

	public void closeSession() {
		driver.quit();
	}
	
	public String takeScreenShot(String name)
	{
		TakesScreenshot screenShoot = (TakesScreenshot) driver;
		
		File screenshotsdata = screenShoot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//img//"+name;
		File screenshotFile = new File(path);
		
		try {
			FileUtils.copyFile(screenshotsdata, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return path;
	}
}
