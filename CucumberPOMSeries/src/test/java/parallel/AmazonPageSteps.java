package parallel;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.deque.axe.AXE;
import com.pages.AmazonPage;
import com.qa.factory.DriverFactory;

import AllyTests.AmazonAllyTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPageSteps {

	private static String title;
	private AmazonPage amazonPage = new AmazonPage(DriverFactory.getDriver());
	private static final URL scriptUrl = AmazonAllyTest.class.getResource("/axe.min.js");

	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().get("http://amazon.in");
		JSONObject responseJson = new AXE.Builder(DriverFactory.getDriver(), scriptUrl).analyze();
		JSONArray violations = responseJson.getJSONArray("violations");
		
		if(violations.length() == 0) {
			System.out.println("No Errors");
		}
		else {
			AXE.writeResults("amazonAllyTest", responseJson);
			Assert.assertTrue(false, AXE.report(violations));
		}
		
		System.out.println("user is on home page");
	}

//	@When("user gets the title of the page")
//	public void user_gets_the_title_of_the_page() {
//		title = loginPage.getLoginPageTitle();
//		System.out.println("Page title is: " + title);
//	}
//
//	@Then("page title should be {string}")
//	public void page_title_should_be(String expectedTitleName) {
//		Assert.assertTrue(title.contains(expectedTitleName));
//	}

}
