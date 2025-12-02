package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility 
{
	private final static By logout = By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 

	public String title()
	{
		return getVisiableText(logout);
	}
}
