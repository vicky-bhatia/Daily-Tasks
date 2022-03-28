package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Flights extends Chrome {
	
	
	By originStation=By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
	By fromDestination=By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//table[@id='citydropdown']//li/a[@value='GAU']");
	By toDestination =By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//table[@id='citydropdown']//li/a[@value='GOI']");
	By departureDate=By.xpath("//table[@class='ui-datepicker-calendar']//tr//a[contains(@class,'ui-state-default') and contains(.,'25')]");
	By passengerType=By.xpath("//label[@for='ctl00_mainContent_chk_StudentDiscount']");
	By findFlights=By.name("ctl00$mainContent$btn_FindFlights");
	By checkbox=By.id("ControlGroupSelectView_AvailabilityInputSelectView_CheckBoxStudentAgreement");
	By continue2=By.id("continue-to-contact-page");
	
	
	JavascriptExecutor j;
  
    
//	public Flights(WebDriver driver)
//	{
//		Chrome.driver=driver;	
//	}
	
//webdriver wait
	
	public void from()
	{
		 driver.findElement(originStation).click();
		 driver.findElement(fromDestination).click();	
	}
	
	public void to()
	{
		driver.findElement(toDestination).click();		
	}
	
	public void departure()
	{
		 driver.findElement(departureDate).click();	
	}
	
	public void passenger()
	{
		 driver.findElement(passengerType).click();	
	}
	
	public void findFlights()
	{
		 driver.findElement(findFlights).click();	
	}
	
	public void checkbox()
	{
		 driver.findElement(checkbox).click();
//		  j = (JavascriptExecutor)driver;
//		  j.executeScript("window.scrollBy(0,500)"); 
	}
	
	public void selectFlightNext()
	{
		 driver.findElement(continue2).click();
	}
	
}
