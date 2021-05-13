package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDemo {
	private By emailId = By.id("email");

	//@Test
	public void t_IEDemo() {
		//System.setProperty("webdriver.ie.driver", "C://Selenium/IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		driver.findElement(emailId).sendKeys("RajuKrish");
		driver.close();
	}
	
	@Test
	public void t1_IEDemo() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement searchTextBox= driver.findElement(By.xpath("//*[@title='Search']"));
		String allCssProperties= searchTextBox.getAttribute("style");
		System.out.println("CSS Properties: "+allCssProperties);
		driver.close();
	}
	


}
