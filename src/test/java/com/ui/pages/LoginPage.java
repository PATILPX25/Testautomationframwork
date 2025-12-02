package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	
	private final static By EMAIL_TEXT = By.xpath("//*[@id='username']");
	private final static By PASSWORD = By.xpath("//*[@id=\"password\"]");
	private final static By NEXTLOGIN = By.xpath("//*[@id=\"submit\"]");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MyAccountPage loginSession(String email, String password) {
		enterText(EMAIL_TEXT, email);
		enterText(PASSWORD, password);
		clickOn(NEXTLOGIN);
		MyAccountPage myaccountpage = new MyAccountPage(getDriver());
		return myaccountpage;
	}
}
