package com.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.constants.Env;
import  com.utility.BrowserUtility;
import com.utility.PropertiesUtil;


public final class HomePage extends BrowserUtility {
	public HomePage(String browserName) throws IOException {
		super(browserName);
//		maxWindow();
		goToWebside(PropertiesUtil.readProperty(Env.QA,"url"));

	}

	public HomePage(Browser browserName) {
		super(browserName);
		maxWindow();
		goToWebside("https://practicetestautomation.com/practice/");

		// TODO Auto-generated constructor stub
	}

	private static final By SIGN_LINK = By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a");

	public LoginPage ClickOnSignIn() {
		clickOn(SIGN_LINK);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
