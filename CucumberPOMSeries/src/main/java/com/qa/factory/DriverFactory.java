package com.qa.factory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "iPhone X"); //iPhone X, iPad Air, Samsung S10(Android Pie9)
		Map<String, Object> chromeOptions = new HashMap<String, Object> ();
		chromeOptions.put("mobileEmulation", mobileEmulation);//https://chromedriver.chromium.org/capabilities
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		

		ChromeDriverService service = new ChromeDriverService.Builder()
		                            .usingDriverExecutable(new File("C://Selenium/chromedriver.exe"))
		                            .usingAnyFreePort()
		                            .build();
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);    
//		tlDriver.set(new ChromeDriver(service, options));
		
//		System.out.println("browser value is: " + browser);
		if(browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver());
		tlDriver.set(new ChromeDriver(service, cap));
			}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
			}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			}
		else if(browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
			}
		else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
