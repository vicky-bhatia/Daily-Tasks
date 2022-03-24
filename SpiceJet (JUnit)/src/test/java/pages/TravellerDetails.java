package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravellerDetails {
	
	WebDriver driver;
	
	By firstName=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName");
	By lastName=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName");
	By moblieNo=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone");
	By email=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress");
	By iAmFlying=By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_SJFlyingView_IamFlying");
	By studentId=By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxDocumentNumber0_0");
	By continueAddOnPage=By.id("continue-to-addons-page");
	By continuePayPage=By.id("continue-to-payment-page");
	By seatAssignment=By.xpath("(//acronym[text()=\"6D\"])[1]");
	
	public TravellerDetails(WebDriver driver)
	{
		this.driver=driver;	
	}
		
	public void firstName(WebDriver driver,String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void lastName(WebDriver driver,String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void moblieNo(WebDriver driver,String number)
	{
		driver.findElement(moblieNo).sendKeys(number);
	}
	
	public void email(WebDriver driver,String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	//j.executeScript("window.scrollBy(0,500)");
	public void iAmFlyingCheckbox(WebDriver driver)
	{
		driver.findElement(iAmFlying).click();
	}
	
	public void studentId(WebDriver driver,String id)
	{
		driver.findElement(studentId).sendKeys(id);
	}
	
	public void continueAddOnPage(WebDriver driver)
	{
		driver.findElement(continueAddOnPage).click();
	}
	
	public void continuePayPage(WebDriver driver)
	{
		driver.findElement(continuePayPage).click();
	}
	
	//       j.executeScript("window.scrollBy(0,500)");
	
	public void seatAssignment(WebDriver driver)
	{
		driver.findElement(seatAssignment).click();
	}
	
	//continueAddOnPage
	
	
	

}
