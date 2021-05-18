package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class DragAndDropPage extends ElementUtil {

	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}
	
	private By drag = By.xpath("//*[@id='credit2']/a");
	private By drop = By.xpath("//*[@id='bank']/li");
	
	public void dd() throws Throwable {
		draganddrop(drag, drop);
	}

}
