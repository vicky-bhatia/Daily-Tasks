package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Flights {
	
	WebDriver driver;
	By originStation=By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
	By fromDestination=By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//table[@id='citydropdown']//li/a[@value='GAU']");
	By toDestination =By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//table[@id='citydropdown']//li/a[@value='GOI']");
	By departureDate=By.xpath("//table[@class='ui-datepicker-calendar']//tr//a[contains(@class,'ui-state-default') and contains(.,'25')]");
	By passengerType=By.xpath("//label[@for='ctl00_mainContent_chk_StudentDiscount']");
	By findFlights=By.name("ctl00$mainContent$btn_FindFlights");
	By checkbox=By.id("ControlGroupSelectView_AvailabilityInputSelectView_CheckBoxStudentAgreement");
	By continue2=By.id("continue-to-contact-page");
	
	
	JavascriptExecutor j;
  
    
	public Flights(WebDriver driver)
	{
		this.driver=driver;	
	}
	
//webdriver wait
	
	public void from(WebDriver driver)
	{
		 driver.findElement(originStation).click();
		 driver.findElement(fromDestination).click();	
	}
	
	public void to(WebDriver driver)
	{
		driver.findElement(toDestination).click();		
	}
	
	public void departure(WebDriver driver)
	{
		 driver.findElement(departureDate).click();	
	}
	
	public void passenger(WebDriver driver)
	{
		 driver.findElement(passengerType).click();	
	}
	
	public void findFlights(WebDriver driver)
	{
		 driver.findElement(findFlights).click();	
	}
	
	public void checkbox(WebDriver driver)
	{
		 driver.findElement(checkbox).click();
//		  j = (JavascriptExecutor)driver;
//		  j.executeScript("window.scrollBy(0,500)"); 
	}
	
	public void selectFlightNext(WebDriver driver)
	{
		 driver.findElement(continue2).click();
	}
	
}
