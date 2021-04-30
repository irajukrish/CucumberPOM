package AllyTests;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deque.axe.AXE;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAllyTest {

	WebDriver driver;
	private static final URL scriptUrl = AmazonAllyTest.class.getResource("/axe.min.js");

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://amazon.in");

	}

	@Test
	public void amazonAllyTest() {

		JSONObject responseJson = new AXE.Builder(driver, scriptUrl).analyze();
		JSONArray violations = responseJson.getJSONArray("violations");
		
		if(violations.length() == 0) {
			System.out.println("No Errors");
		}
		else {
			AXE.writeResults("amazonAllyTest", responseJson);
			Assert.assertTrue(false, AXE.report(violations));
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
