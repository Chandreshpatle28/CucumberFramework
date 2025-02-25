package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Customer.feature",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		//plugin = {"pretty","html:target/cucumber-reports/reports1.html","junit:target/cucumber-reports/reports_xml.xml","json:target/cucumber-reports/reports_json.json"}
		//plugin = {"pretty","json:target/cucumber-reports/reports_json.json"}
	    //plugin = {"pretty","junit:target/cucumber-reports/reports_xml.xml"}
)


public class Run 
{
	//This class will be empty
}
