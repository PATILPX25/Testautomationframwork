package step_def;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	WebDriver driver;

	@Given("launch browser")
	public void launch_browser() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ppatil88\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// Create a new instance of ChromeDriver

		ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options); // Launch chrome browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("set url")
	public void set_url() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
	
		
		driver.get("https://talent.capgemini.com/in");
		Thread.sleep(3000);
		driver.navigate().refresh();
		JavascriptExecutor js = (JavascriptExecutor) driver;

//		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Close')])[1]"));
//		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(90, document.body.scrollHeight);");
		Thread.sleep(20000);
		WebElement we = driver.findElement(By.xpath("//*[@title='Innovation Theater']"));
		js.executeScript("arguments[0].scrollIntoView(true)", we);
		Thread.sleep(2200);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2200);

	}

	@Then("verify title")
	public void verify_title() throws IOException {
		// Write code here that turns the phrase above into concrete actions
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		String location = "C:\\Users\\ppatil88\\eclipse-workspace\\BDD\\img";
//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		File dest = new File(location + "\\img" + timestamp + ".png");
//		FileHandler.copy(src, dest);
	}

	@Then("login as student")
	public void user_login() {

//		driver.findElement(By.id("username")).sendKeys(configreader.getProperty("username"));
//		driver.findElement(By.id("password")).sendKeys(configreader.getProperty("password"));
//		driver.findElement(By.id("submit")).click();

	}

	@Then("verify login is succesfull")
	public void verify_login_page() throws InterruptedException {
		Thread.sleep(50);
		driver.findElement(By.xpath("//*[@id='megamenu-news']/a")).click();

		List<WebElement> links = driver.findElements(By.xpath(
				"//*[contains(@id, 'E612D') or contains(@id, 'F4FEFA02') or contains(@id, '4516D386')]/following-sibling::ul/li/a"));

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty or null");
				continue;
			}

			try {
				@SuppressWarnings("deprecation")
				HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();

				if (responseCode == 401) {
					System.out.println("Broken link: " + url + " - Code: " + responseCode);
				} else {
					System.out.println("Valid link: " + url + " - Code: " + responseCode);
				}
			} catch (Exception e) {
				System.out.println("Error checking link: " + url + " - " + e.getMessage());
			}

			// for (WebElement we : elements) {
//			System.out.println(we.getText());
//			we.click();
//			Thread.sleep(20000);
//		}
			Thread.sleep(200);
//		driver.findElement(By.xpath("//*[@id='in_megamenu-news_megamenu']/button/img")).click();
		}
	}

	@Then("close session")
	public void close_session() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Close')])[2]"));
		js.executeScript("arguments[0].click();", element);
//		Thread.sleep(2000);
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(200);
		driver.quit();
	}

}
