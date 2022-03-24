package step_Definition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.Flights;

public class Flights_steps {
	
	WebDriver driver;
	JavascriptExecutor j;
	Flights obj=new Flights(driver);

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Given("User open URL {string}")
	public void user_open_url(String string) {
		String website="https://corporate.spicejet.com/Default.aspx";
		driver.get(website);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		driver.manage().window().maximize();//Maximize Window
	}
	

	@When("User select departure city")
	public void user_select_departure_city() {
		obj.from(driver);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@When("User select arrival city")
	public void user_select_arrival_city() {
		obj.to(driver);
	}

	@When("User select departure date")
	public void user_select_departure_date() {
		obj.departure(driver);
	}
	
	@When("User select passenger type")
	public void user_select_passenger_type() {
		obj.passenger(driver);
	}

	@Then("User click on search flights")
	public void user_click_on_search_flights() {
		obj.findFlights(driver);
	}
	
	@When("user select the student discount checkbox")
	public void user_select_the_student_discount_checkbox() {
		obj.checkbox(driver);
		j = (JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(0,500)");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Then("user click on continue button")
	public void user_click_on_continue_button() {
		obj.selectFlightNext(driver);
	}
}
