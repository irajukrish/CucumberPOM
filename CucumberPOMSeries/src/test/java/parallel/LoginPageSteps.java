package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import com.qa.util.XLUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testrunners.MyTestRunner;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		System.out.println("user is on login page");
	}

	@When("<{int}> users logs in")
	public void users_logs_in(Integer Users) throws InvalidFormatException, IOException {
		System.out.println("Users logs in");
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testData = reader.getData("Credentials.xlsx", "Sheet2");

		for (int i = 0; i < Users; i++) {
			String username = testData.get(i).get("username");
			String password = testData.get(i).get("password");
			loginPage.doLogin(username, password);
		}

	}
	
	@When("User enter Username as {string} and Password as {string}")
	public void user_enter_username_as_and_password_as(String username, String password) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		System.out.println("Examples Output");
	}
	
	@When("<{int}> Users enters Credentials to LogIn")
	public void users_enters_credentials_to_log_in(Integer Users, DataTable usercredentials) {
		List<List<String>> data = usercredentials.asLists(String.class);
		for (int i = 0; i < Users; i++) {
		loginPage.enterUserName(data.get(i).get(0));
		loginPage.enterPassword(data.get(i).get(1));
		loginPage.clickOnLogin();
		loginPage.clickSignOut();
		}
		System.out.println("Data Table Output");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

}
