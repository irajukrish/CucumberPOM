package com.pages;

import org.openqa.selenium.WebDriver;

public class AmazonPage {
	private WebDriver driver;

	public AmazonPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
}
