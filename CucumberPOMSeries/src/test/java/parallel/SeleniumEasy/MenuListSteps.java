package parallel.SeleniumEasy;

import org.testng.Assert;

import com.pages.LoginPage;
import com.pages.MenuListPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class MenuListSteps {
	
	String GetInputText;
	private MenuListPage menuListPage = new MenuListPage(DriverFactory.getDriver());
	
	@Given("user is on Selenium Easy")
	public void user_is_on_selenium_easy() {
		DriverFactory.getDriver()
		.get("https://www.seleniumeasy.com/test/");
		System.out.println("user is on Selenium Easy");
	}

	@Given("user navigates to Simple form")
	public void user_navigates_to_simple_form() {
		System.out.println("user navigates to Simple form");
		menuListPage.NavigatetoSimpleForm();
	}

	@When("user inputs Message {string}")
	public void user_inputs_message(String string) {
		System.out.println("user inputs Message " + string);
		menuListPage.InputMessage(string);
		this.GetInputText=string;
	}

	@When("user clicks on the Show Message")
	public void user_clicks_on_the_show_message() {
		System.out.println("user clicks on the Show Message");
		menuListPage.SubmitMessage();
	}
	

	@Then("validate the user Message")
	public void validate_the_user_message() {
		System.out.println("validate the user Message");
		String text=menuListPage.GetthedisplayedMessage();
		//Assert.assertEquals(text,"Raju Krish is a great guy");
		Assert.assertEquals(text,GetInputText);
		
	}
	
	@Given("user navigates to checkbox form")
	public void user_navigates_to_checkbox_form() {
		menuListPage.Navigatetocheckbox();
	}

	@When("user select the checkbox")
	public void user_select_the_checkbox() {
		menuListPage.Selectcheckbox();		
	}

	@Then("validate the display Message")
	public void validate_the_display_message() {
		String actualmsg=menuListPage.GetcheckboxMessage();
		//Assert.assertEquals(actualmsg, "Success - Check box is checked");
		System.out.println("validate the display Message");
	}
	
	
	@Given("user navigates to Radiobutton")
	public void user_navigates_to_radiobutton() {
		menuListPage.Navigattoradio();
	}

	@When("user select the Radiobutton")
	public void user_select_the_radiobutton() {
		menuListPage.Selectradio();
	}

}
