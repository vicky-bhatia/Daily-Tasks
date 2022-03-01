package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTemperature {
		
		File file;
		FileInputStream fileInput;
		Properties prop;
		WebDriver driver;

		@BeforeTest
		public void setUp() throws IOException  {
			file=new File("config.properties");// Create the File object and pass the 'properties file location in File constructor.
			fileInput=new FileInputStream(file);//Create FileInputstream object to read the file
			prop=new Properties();// Create properties class object
			prop.load(fileInput);// Load the property file in Inputstream
			
			if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
			{
				ChromeOptions options = new ChromeOptions();  
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().browserVersion(prop.getProperty("browserVersion")).setup();
				driver=new ChromeDriver(options);
			}
			
			else if(prop.getProperty("browserName").equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}

			driver.get(prop.getProperty("websiteUrl"));//Open NDTV
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		}

		@Test
		public void test() throws InterruptedException {
			WebElement searchBox;
			By selectMore=By.cssSelector(prop.getProperty("more_id"));
			By selectWeather=By.xpath(prop.getProperty("weather_xpath"));
			By selectSearchBox=By.xpath(prop.getProperty("searchBox_xpath"));
			By getDegree=By.xpath(prop.getProperty("degree_xpath"));
			By getFahrenheit=By.xpath(prop.getProperty("fahrenheit_xpath"));

			driver.findElement(selectMore).click(); //click on more
			driver.findElement(selectWeather).click(); //click on weather

			Thread.sleep(2000);

			String removeAllCity[]= prop.getProperty("remove").toString().split("#");//Removes all the pinned cities from the map

			for(int r=0;r<removeAllCity.length;r++)
			{
				searchBox=driver.findElement(selectSearchBox);
				searchBox.sendKeys(removeAllCity[r]);
				By deSelectCity=By.xpath("//label[@for='"+removeAllCity[r]+"']");
				driver.findElement(deSelectCity).click();
				searchBox.clear();
			}

			String enterCity[]= prop.getProperty("requiredCities").toString().split("#");//Enter city names whose temperature is required.

			for(int j=0;j<enterCity.length;j++)
			{
				By selectCity=By.xpath("//label[@for='"+enterCity[j]+"']");
				By cityOnMap=By.xpath("//div[@class='cityText' and text()='"+enterCity[j]+"']");

				searchBox=driver.findElement(selectSearchBox);// click on searchBar
				searchBox.sendKeys(enterCity[j]);//Enter city name

				driver.findElement(selectCity).click();//select city checkbox
				searchBox.clear(); //clear city name in searchbar

				driver.findElement(cityOnMap).click();//click on city in map
				Thread.sleep(1000);
				String degree=driver.findElement(getDegree).getText();
				String Fahrenheit=driver.findElement(getFahrenheit).getText();
				System.out.println(enterCity[j]+"\n"+degree+"\n"+Fahrenheit+"\n");
			}

		}
}
