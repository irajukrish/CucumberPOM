package parallel;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import com.pages.ContactUsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

	private ContactUsPage Contactuspage = new ContactUsPage(DriverFactory.getDriver());

	@Given("User is on Contact us page")
	public void user_is_on_contact_us_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		Contactuspage.navigatetoContactUs();
		System.out.println("user is on Contact us page");
		
		
		String contactusTitle=Contactuspage.getContactUsPageTitle();
		
		Assert.assertEquals("Contact us - My Store", contactusTitle);
		
	}

	@When("Send a message")
	public void send_a_message() {
		System.out.println("Send a Message");
	}

	@Then("Confirmation message")
	public void confirmation_message() {
		System.out.println("Confirmation for sent Message");
	}

}
