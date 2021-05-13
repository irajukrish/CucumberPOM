package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class MenuListPage extends ElementUtil {
	
	private WebDriver driver;
	
	
	public MenuListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// 1. By Locators: OR
	private By inputForms = By.xpath("(//a[contains(text(),'Input Forms')])[2]");
	private By simpleForm = By.xpath("(//a[contains(text(),'Simple Form Demo')])[2]");
	private By inputMessage = By.xpath("(//input[@id='user-message'])[1]");
	private By showMessagebtn = By.xpath("//button[contains(text(),'Show Message')]");
	private By displayMessage = By.xpath("//span[@id='display']");

	
	
	public void NavigatetoSimpleForm() {
		elementClick(inputForms);
		elementClick(simpleForm);
	}
	
	public void InputMessage(String str) {
		elementSendKeys(inputMessage, str);	
		
	}
	
	public void SubmitMessage() {
		elementClick(showMessagebtn);		
	}
	
	public String GetthedisplayedMessage() {
		String text=getText(displayMessage);
		return text;
	}

}
