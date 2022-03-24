package test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/C_Flights.feature",
					 glue = { "step_Definiton" },
					 monochrome = true)
					 
public class TestRun {

}
