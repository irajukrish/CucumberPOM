package parallel;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

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
		
		String visibility = DriverFactory.getDriver().findElement(By.linkText("Contact us")).getCssValue("font-size");
		System.out.println("Font Size is " + visibility);
		WebElement element =DriverFactory.getDriver().findElement(By.linkText("Contact us"));
		System.out.println("Location: " +  element.getLocation() + " ,Size: " + element.getSize() ); 
		
	}

	@When("Send a message")
	public void send_a_message() {
		WebElement element =DriverFactory.getDriver().findElement(By.xpath("//*[@class='action']"));
		String chooseFile_Color=element.getCssValue("background-color");
		String hexcolor = Color.fromString(chooseFile_Color).asHex();
		System.out.println("Color of Choose File button is " + chooseFile_Color);
		System.out.println("Color of Choose File button in Hexcolor code is " + hexcolor);		
		System.out.println("Send a Message");
		
		
		WebElement search =DriverFactory.getDriver().findElement(By.id("search_query_top"));
		System.out.println("----------------------------------------------------------------------");
		String allCssProperties= search.getAttribute("ac_results");
		System.out.println("CSS Properties: "+allCssProperties);
		System.out.println("----------------------------------------------------------------------");
	}

	@Then("Confirmation message")
	public void confirmation_message() {
		WebElement element =DriverFactory.getDriver().findElement(By.id("submitMessage"));
		String sendbtn_Color=element.getCssValue("Color");
		String hexcolor = Color.fromString(sendbtn_Color).asHex();
		System.out.println("Color of Send button in Hexcolor code is " + hexcolor);
		try {
		Assert.assertEquals("#fffffc", hexcolor);
		}
		catch(AssertionError e){
			System.out.println("Color of Send button doesn't match please fix this quickly" + e);
		}
		String sendbtn_height=element.getCssValue("height");
		String sendbtn_width=element.getCssValue("width");
		System.out.println("Height: " + sendbtn_height + " , Widgth: " + sendbtn_width);
		
		String sendbtn_font=element.getCssValue("font-family");
		System.out.println("Font of Send button is " + sendbtn_font);
		System.out.println("Confirmation for sent Message");
		
		System.out.println("----------------------------------------------------------------------");
		String allCssProperties= element.getAttribute("style");
		System.out.println("CSS Properties: "+allCssProperties);
		System.out.println("----------------------------------------------------------------------");
	}

}
