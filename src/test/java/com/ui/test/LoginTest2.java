package com.ui.test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest2 {
	@Test(priority = 0)
	public void printvalue()
	{
		System.out.println("Test emthode");
	}
	
	@Test(priority = 1)
    public void webdriver()
    {
        // Verbose driver log
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://example.com");
            System.out.println("Title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}
