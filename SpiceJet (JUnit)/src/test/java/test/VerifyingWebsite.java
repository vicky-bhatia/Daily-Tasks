package test;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Flights;
import pages.TravellerDetails;

public class VerifyingWebsite {
	
	@Test
	public void verify(){

		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String website="https://corporate.spicejet.com/Default.aspx";
		driver.get(website);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().window().maximize();//Maximize Window
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
      
        Flights obj=new Flights(driver);
        obj.from();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        obj.to();
        obj.departure();
        obj.passenger();
        obj.findFlights();
        obj.checkbox();
        j.executeScript("window.scrollBy(0,500)");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        obj.selectFlightNext();
        
        TravellerDetails obj1=new TravellerDetails(driver);
        
        obj1.firstName("Vicky");
        obj1.lastName("Bhatia");
        obj1.moblieNo("8178007321");
        obj1.email("vickybhatia1507@gmail.com");
        
        j.executeScript("window.scrollBy(0,500)");
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        obj1.iAmFlyingCheckbox();
        obj1.studentId("1813310012");
        obj1.continueAddOnPage();
        obj1.continuePayPage();
        
        j.executeScript("window.scrollBy(0,500)");
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        obj1.seatAssignment();
        obj1.continueAddOnPage();
        
        
        
	}
        

}
