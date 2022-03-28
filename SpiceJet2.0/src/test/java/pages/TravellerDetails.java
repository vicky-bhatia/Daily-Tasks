package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravellerDetails extends Chrome{
	
	By firstName=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName");
	By lastName=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName");
	By moblieNo=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone");
	By email=By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress");
	By iAmFlying=By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_SJFlyingView_IamFlying");
	By studentId=By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxDocumentNumber0_0");
	By continueAddOnPage=By.id("continue-to-addons-page");
	By continuePayPage=By.id("continue-to-payment-page");
	By seatAssignment=By.xpath("(//acronym[text()=\"6D\"])[1]");
	
//	public TravellerDetails()
//	{
//		this.driver=driver;	
//	}
		
	public void firstName(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void moblieNo(String number)
	{
		driver.findElement(moblieNo).sendKeys(number);
	}
	
	public void email(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	//j.executeScript("window.scrollBy(0,500)");
	public void iAmFlyingCheckbox()
	{
		driver.findElement(iAmFlying).click();
	}
	
	public void studentId(String id)
	{
		driver.findElement(studentId).sendKeys(id);
	}
	
	public void continueAddOnPage()
	{
		driver.findElement(continueAddOnPage).click();
	}
	
	public void continuePayPage()
	{
		driver.findElement(continuePayPage).click();
	}
	
	//       j.executeScript("window.scrollBy(0,500)");
	
	public void seatAssignment()
	{
		driver.findElement(seatAssignment).click();
	}
	
	//continueAddOnPage

}
