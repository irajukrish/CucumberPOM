package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class MenuListPage extends ElementUtil {
	
	//private WebDriver driver;
	
	
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
	
	private By checkbox = By.xpath("(//a[contains(text(),'Checkbox Demo')])[2]");
	private By selectCheckbox = By.xpath("(//label/input[@id='isAgeSelected'])[1]");
	private By chkboxselectedmessage = By.xpath("//*[@id='txtAge']");
	private By radiobtn= By.xpath("(//a[contains(text(),'Radio Buttons Demo')])[2]");
	private By maleRadiobtn=By.xpath("(//*[@value='Male'])[1]");
	private By checkedvalue=By.xpath("(//*[@id='buttoncheck'])[1]");

	
	
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
	
	public void Navigatetocheckbox() {
		elementClick(inputForms);
		elementClick(checkbox);
	}
	
	public void Selectcheckbox() {
		elementClick(selectCheckbox);
		//jsexecutorClick(selectCheckbox);
		
	}
	
	public String GetcheckboxMessage() {		
		String text=getText(chkboxselectedmessage);
		return text;				
	}
	
	public void Navigattoradio() {
		elementClick(inputForms);
		elementClick(radiobtn);
	}
	
	public void Selectradio() {
		elementClick(maleRadiobtn);
		elementClick(checkedvalue);
	}

}
