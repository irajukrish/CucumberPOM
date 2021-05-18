package parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/parallel"},
		glue = {"parallel"},
		
		plugin = {"pretty",				
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"json:target/cucumber.json",
				"html:target/cucumber-reports"},
		monochrome = true
		//,tags = "@ContactUs"
		
		)


public class ParallelRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}

}
