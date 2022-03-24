package training1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.findElement(By.cssSelector("[type=email]")).sendKeys("atesting.1507@gmail.com");;
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[type=password]")).sendKeys("Qwer5678");
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
		
		

	}

}
