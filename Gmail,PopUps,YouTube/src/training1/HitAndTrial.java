package training1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class HitAndTrial {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String website="https://corporate.spicejet.com/Default.aspx";
		driver.get(website);
		
		Thread.sleep(2000);
		driver.manage().window().maximize();//Maximize Window
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"))).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//table[@id='citydropdown']//li/a[@value='GAU']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//table[@id='citydropdown']//li/a[@value='GOI']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='ui-datepicker-calendar']//tr//a[contains(@class,'ui-state-default') and contains(.,'22')]"))).click();
        driver.findElement(By.xpath("//label[@for=\"ctl00_mainContent_chk_StudentDiscount\"]")).click();
        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ControlGroupSelectView_AvailabilityInputSelectView_CheckBoxStudentAgreement")).click();
        Thread.sleep(2000);
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
//        String FlightNumber = driver.findElement(By.xpath("(//span[contains(text(),\"SG 680\")])[1]")).getText();
//        System.out.println(FlightNumber);
//        
        		
        driver.findElement(By.id("continue-to-contact-page")).click();
        
    //************************************************************************************************************************//
        
       WebElement firstName= driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName"));
       //firstName.click();
       firstName.sendKeys("Vicky");
       
       WebElement lastName= driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName"));
       //lastName.click();
       lastName.sendKeys("Bhatia");
       
       WebElement mobile= driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone"));
       mobile.click();
       mobile.sendKeys("8178007321");
       
       WebElement email= driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress"));
       email.click();
       email.sendKeys("vickybhatia1507@gmail.com");
       
       j.executeScript("window.scrollBy(0,500)");
       Thread.sleep(2000);
       driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_SJFlyingView_IamFlying")).click();
       Thread.sleep(2000);
//       
       WebElement id= driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxDocumentNumber0_0"));
       id.click();
       id.sendKeys("1813310232");
       
       driver.findElement(By.id("continue-to-addons-page")).click();
       driver.findElement(By.id("continue-to-payment-page")).click();

       j.executeScript("window.scrollBy(0,500)");
       
       driver.findElement(By.xpath("(//acronym[text()=\"12A\"])[1]")).click();
       driver.findElement(By.id("continue-to-addons-page")).click();
       
       
       
       
       
       
       
        
    }
//		Thread.sleep(5000);
//		System.out.println("1111111");
//		WebElement d=obj1.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
//		System.out.println("2222222");
//		System.out.println("3333333333");
//		d.click();
//		System.out.println("44444444444");
//		d.sendKeys("COK");
//		System.out.println("555555555");
//		obj1.findElement(By.linkText("Kochi (COK)")).click();
//		System.out.println("6666666666");
		
//		d.click();
//		Thread.sleep(5000);
//		obj1.findElement(By.xpath("//a[@value='MAA']")).click();
//		//d.sendKeys("chen");
//		
//		Select dropDown1 = new Select(d);            
//		dropDown1.selectByIndex(2);
		
		//obj1.findElement(By.xpath("//div[contains(text(),\"BLR\")]")).click();
		//div[contains(text(),"Indira Gandhi International Airport")]

}
