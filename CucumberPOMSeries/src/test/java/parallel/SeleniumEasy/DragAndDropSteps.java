package parallel.SeleniumEasy;

import com.pages.DragAndDropPage;
import com.pages.MenuListPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DragAndDropSteps {
	
	private DragAndDropPage dragAndDropPage = new DragAndDropPage(DriverFactory.getDriver());
	
	@Given("user is on Guru99")
	public void user_is_on_guru99() {
	    // Write code here that turns the phrase above into concrete actions
		DriverFactory.getDriver()
		.get("http://demo.guru99.com/test/drag_drop.html");
	}

	@When("Drag and drop the element on Credit side")
	public void drag_and_drop_the_element_on_credit_side() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dragAndDropPage.dd();
	}


}
