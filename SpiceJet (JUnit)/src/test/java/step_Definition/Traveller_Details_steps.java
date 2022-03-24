package step_Definition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.TravellerDetails;

public class Traveller_Details_steps{
	
	WebDriver driver;
	JavascriptExecutor k,l;
	TravellerDetails obj1=new TravellerDetails(driver);
	
	@Given("User is on traveller detail page")
	public void user_is_on_traveller_detail_page() {
		System.out.println("User is on traveller detail page");
	}

	@Given("user enter first name")
	public void user_enter_first_name() {
		obj1.firstName(driver,"Vicky");
	}

	@Given("user enter last name")
	public void user_enter_last_name() {
        obj1.lastName(driver,"Bhatia");
	}

	@Given("user enter Mobile Number")
	public void user_enter_mobile_number() {
		obj1.moblieNo(driver,"8178007321");
	}

	@Given("user enter email ID")
	public void user_enter_email_id() {
        obj1.email(driver,"vickybhatia1507@gmail.com");
	}

	@When("user selects the i am flying checkbox")
	public void user_selects_the_i_am_flying_checkbox() {
		k = (JavascriptExecutor)driver;
        k.executeScript("window.scrollBy(0,500)");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
        obj1.iAmFlyingCheckbox(driver);
	}

	@When("user enter the student ID")
	public void user_enter_the_student_id() {
        obj1.studentId(driver,"1813310012");
	}

	@Then("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		obj1.continueAddOnPage(driver);
	}
	

	@Then("user clicks on continue")
	public void user_clicks_on_continue() {
        obj1.continuePayPage(driver);
	}
	
	@Then("user selects his seat")
	public void user_selects_his_seat() {
		l = (JavascriptExecutor)driver;
        l.executeScript("window.scrollBy(0,500)");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        obj1.seatAssignment(driver);
	}
	
	@Then("user clicks continue to payment page")
	public void user_clicks_continue_to_payment_page() {
		obj1.continueAddOnPage(driver);
	}

}
