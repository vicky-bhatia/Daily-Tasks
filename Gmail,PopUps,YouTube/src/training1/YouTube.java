package training1;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YouTube {
	//****************Recording Link -- > https://screencast-o-matic.com/watch/c3norlVbI6W********************************************
	public static int changeTime(String t)
	{
		String units[] = t.split(":"); //It will break the string up into an array
		int min = Integer.parseInt(units[0]); //first element
		int sec = Integer.parseInt(units[1]); //second element
		int duration = 60 * min + sec;
		return duration;
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");//Launch Chrome
		WebDriver obj1=new ChromeDriver();//creates object of WebDriver class 
		Actions act=new Actions(obj1);//Creates object of Actions class
		obj1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//global wait
		
		String website="https://www.youtube.com";
		String searchInput="boss baby official trailer";
		
		obj1.get(website);//opens YouTube
		obj1.manage().window().maximize();//Maximize Window
		WebElement searchTextbox=obj1.findElement(By.xpath("//input[@id=\"search\"]"));
		searchTextbox.sendKeys(searchInput);//Enter video title to be searched
		
		Thread.sleep(2000);
		
		WebElement searchIcon=obj1.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]//child::yt-icon"));
		searchIcon.click();//Clicks on search icon
		WebElement playVideo=obj1.findElement(By.cssSelector("[title=\"The Boss Baby Official Trailer 1 (2017) - Alec Baldwin Movie\"]"));
		playVideo.click();//Plays video
		
		Thread.sleep(5000);
		
		act.moveToElement(obj1.findElement(By.xpath("//video[@controlslist=\"nodownload\"]"))).build().perform();//Move mouse to the target element(in this case over the video)
		String ft=obj1.findElement(By.className("ytp-time-duration")).getText();
		int finalDuration=changeTime(ft);
		int currentDuration=0;
		WebElement overVideo = obj1.findElement(By.xpath("//div[@id=\"movie_player\"]"));
		
		while (currentDuration<finalDuration)
		{
			Thread.sleep(2000);
			overVideo.click();
			WebElement temp = obj1.findElement(By.xpath("//span[@class=\"ytp-time-current\"]"));
			String currentTime = "00:00";
			currentTime = temp.getText();
			currentDuration = changeTime(currentTime);
			if (currentDuration % 5 == 0)
			{
				System.out.println(currentTime + "/" + ft);
			}
			overVideo.click();
		}

	}

}
