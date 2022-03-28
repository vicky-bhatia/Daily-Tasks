package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {
	
		public static WebDriver driver;
		public void launchChromeBrowser() throws Throwable {
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}

}
