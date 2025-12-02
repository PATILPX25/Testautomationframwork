package com.JavaScript;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RunTestUsingJavaScript {

	WebDriver driver;
	@BeforeMethod
	public void launch()
	{
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	@Test(invocationCount = 1)
	public void launch_driver() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://talent.capgemini.com/in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Explicit wait
//		WebDriverWait ws = new WebDriverWait(driver, Duration.ofSeconds(300));
//		WebElement WE = ws.until(ExpectedConditions
//				.elementToBeClickable(driver.findElement(By.xpath("(//*[contains(text(),'Close')])[1]"))));
		
//		System.out.println("status is :"+ WE.isDisplayed());
		

		WebDriverWait waita = new WebDriverWait(driver, Duration.ofSeconds(60));
//		Alert aa = waita.until(ExpectedConditions.alertIsPresent());
		
		driver.findElement(By.xpath("(//*[contains(text(),'Close')])[1]")).click();
		// Fluent wait

//		Wait<WebDriver> waitf = new FluentWait<>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(2))
//		        .ignoring(NoSuchElementException.class);
//
//		WebElement element = waitf.until(driver -> {
//			WebElement el = driver.findElement(By.xpath("(//*[contains(text(),'Close')])[1]"));
//			return (el.isDisplayed() && el.isEnabled()) ? el : null;
//		});

//		element.click();
//
//		WE.click();
//		String title = js.executeScript("return document.title;").toString();
//		System.out.println(title);
//		Thread.sleep(10);
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.navigate().to("https://www.google.com");
//		Thread.sleep(180);
//
//		System.out.println("This is window handle" + driver.getWindowHandle());
//		js.executeScript("window.location = 'https://demo.guru99.com/'");
//		driver.close();
//		Thread.sleep(30);

//		driver.quit();
	}
//	
//	@Test(invocationCount = 3)
//	public void atest()
//	{
//		System.out.println("Jist run second test.....");
//	}
	
};