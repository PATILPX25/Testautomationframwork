package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.LoggerUtility;
import com.utility.User;

@Listeners(com.ui.listners.iTestMyListners.class)
public class LoginTest {

    private static final Logger logger = LoggerUtility.getLogger(LoginTest.class);
	
	@Test(description = "login to system", groups = {
			"sanity" }, dataProviderClass = com.dataprovider.LoginDataProvider.class, dataProvider = "LoginCSVData")
	public void test(User user) {
		
//		Logger logger = LoggerUtility.getLogger(this.getClass());
		logger.info("this is log started");
		logger.error("this is errrrrrrrrrrrrrrrrrro");
		HomePage hp = new HomePage(Browser.chrome);
		String title = hp.ClickOnSignIn().loginSession(user.getEmail(), user.getPassword()).title();
		hp.closeSession();
		System.out.println("Title is " + title);
		
//		logger.info("End of test methode:" + this.getClass());
//		hp.ClickOnSignIn();
//		LoginPage lp = new LoginPage(driver);
//		lp.loginSession("student", "Password123");
//		MyAccountPage ma = new MyAccountPage(driver);
//		System.out.println("Login and tile is now"+ ma.title());

	}

}
