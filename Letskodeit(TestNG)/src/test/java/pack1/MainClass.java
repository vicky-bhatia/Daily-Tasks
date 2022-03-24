package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClass extends DynamicYamlReader{
	File file;
	FileInputStream fileInput;
	Properties prop;

	WebDriver driver;
	String parentWindow;

	@BeforeTest
	public void setUp() throws Throwable
	{
		file=new File("config.properties");
		fileInput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileInput);
		String browser;

		browser = prop.getProperty("browserName");
		//		browser = System.getProperty("browserName");

		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();  
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}

		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		//		driver.get(prop.getProperty("websiteUrl"));
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}

	@AfterTest
	public void close() throws InterruptedException
	{
		driver.quit();
	}

	@Test(priority = 1)
	public void testRadioButton() throws Throwable
	{
		WebElement demo= driver.findElement(By.cssSelector(getData("radioButton.bmw.cssSelector")));
		demo.click();
		List<WebElement> allRadio=driver.findElements(By.cssSelector("input[name=\"cars\"][type=\"radio\"]"));
		int	count=0;
		for(int i=0;i<allRadio.size();i++)
		{
			WebElement temp=allRadio.get(i);
			if(temp.isSelected()) {					
				count++;
			}					
		}
		try {
			Assert.assertEquals(count, 1);
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
	}

	@Test(priority = 2)
	public void testSelectClass() throws Throwable
	{
		WebElement selected=driver.findElement(By.cssSelector(getData("selectClass.carSelect")));
		selected.click();
		WebElement demo= driver.findElement(By.cssSelector(getData("selectClass.honda")));
		demo.click();
		List<WebElement> allCarOptions=driver.findElements(By.xpath("//select[@id='carselect']/option"));
		int	count=0;
		for(int i=0;i<allCarOptions.size();i++)
		{
			WebElement temp=allCarOptions.get(i);
			if(temp.isSelected()) {					
				count++;
			}					
		}
		if(demo.isSelected() && demo.isDisplayed() && count==1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@Test(priority = 3)
	public void testMultipleSelect() throws Throwable
	{
		WebElement selected1=driver.findElement(By.cssSelector(getData("multipleSelect.apple")));
		selected1.click();
		WebElement selected2 = driver.findElement(By.cssSelector(getData("multipleSelect.orange")));
		selected2.click();
		List<WebElement> selected = new ArrayList<WebElement>();
		selected.add(selected1);
		selected.add(selected2);
		int	count=0;
		List<WebElement> allFruits=driver.findElements(By.xpath("//select[@id=\"multiple-select-example\"]//option"));
		for(int i=0;i<allFruits.size();i++)
		{
			WebElement temp=allFruits.get(i);
			if(temp.isSelected()) {					
				count++;
			}					
		}
		try {
			Assert.assertEquals(count, selected.size());
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
	}

	@Test(priority = 4)
	public void testCheckbox() throws Throwable
	{
		WebElement demo1= driver.findElement(By.cssSelector(getData("checkboxSelect.bmw")));
		demo1.click();
		WebElement demo2= driver.findElement(By.cssSelector(getData("checkboxSelect.honda")));
		demo2.click();
		List<WebElement> selected = new ArrayList<WebElement>();
		selected.add(demo1);
		selected.add(demo2);
		List<WebElement> allCheckbox=driver.findElements(By.cssSelector("input[name='cars'][type='checkbox']"));
		int	count=0;
		for(int i=0;i<allCheckbox.size();i++)
		{
			WebElement temp=allCheckbox.get(i);
			if(temp.isSelected()) {					
				count++;
			}					
		}
		try {
			Assert.assertEquals(count, selected.size());
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
	}

	@Test(priority = 5)
	public void testSwitchWindow() throws Throwable  {
		parentWindow=driver.getWindowHandle();
		driver.findElement(By.cssSelector(getData("switchWindow.openWindow"))).click();
		Set<String> newWindow=driver.getWindowHandles();
		String[] str1 = newWindow.toArray(new String[newWindow.size()]);
		driver.switchTo().window(str1[1]);
		Thread.sleep(2000);
		WebElement title= driver.findElement(By.cssSelector(getData("switchWindow.title")));
		try {
			Assert.assertEquals(title.isDisplayed(), true);
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
		driver.findElement(By.xpath(getData("switchWindow.selectCourse"))).click();	
		driver.close();
	}

	@Test(priority = 6)
	public void testSwitchTab() throws Throwable {
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector(getData("switchTab.openTab"))).click();
		Set<String> newTab=driver.getWindowHandles();
		String[] str2 = newTab.toArray(new String[newTab.size()]);
		driver.switchTo().window(str2[1]);
		WebElement title2= driver.findElement(By.cssSelector(getData("switchWindow.title")));
		try {
			Assert.assertEquals(title2.isDisplayed(), true);
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
		driver.findElement(By.xpath(getData("switchWindow.selectCourse"))).click();
		driver.close();
	}

	@Test(priority = 7)
	public void testSwitchToAlert() throws Throwable {
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector(getData("switchToAlert.enterName"))).sendKeys("Vicky Bhatia");
		driver.findElement(By.cssSelector(getData("switchToAlert.alert"))).click();
		Thread.sleep(1000);
		Alert obj;
		obj=driver.switchTo().alert();
		String alertText1=obj.getText();
		String text1="share this practice page and share your knowledge";
		obj.accept();
		driver.findElement(By.cssSelector(getData("switchToAlert.confirm"))).click();
		obj=driver.switchTo().alert();
		String alertText2=obj.getText();
		String text2="Are you sure you want to confirm?";
		obj.accept();
		if(alertText1.contains(text1) && alertText2.contains(text2) )
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);			
	}

	//Web Table Example//

	@Test(priority = 8)
	public void testEnabledDisabled() throws Throwable {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		WebElement input=driver.findElement(By.cssSelector(getData("enabled/Disabled.input")));
		input.sendKeys("Check disable ");
		driver.findElement(By.cssSelector(getData("enabled/Disabled.disable"))).click();
		int count=0;
		if(!input.isEnabled())
			count++;
		driver.findElement(By.cssSelector(getData("enabled/Disabled.enable"))).click();
		input.sendKeys("check enable");
		if(input.isEnabled())
			count++;

		try {
			Assert.assertEquals(count, 2);
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
	}

	@Test(priority = 9)
	public void testElementDisplayed() throws Throwable {
		int count=0;
		WebElement input2=driver.findElement(By.cssSelector(getData("elementDisplayed.input")));
		input2.sendKeys("Good Morning");
		driver.findElement(By.cssSelector(getData("elementDisplayed.hide"))).click();
		if(!input2.isDisplayed())
			count++;
		driver.findElement(By.cssSelector(getData("elementDisplayed.show"))).click();
		if(input2.isDisplayed())
			count++;
		try {
			Assert.assertEquals(count, 2);
		}
		catch(AssertionError e) {
			Assert.fail();
			System.out.println(e.toString());
		}
	}

	@Test(priority = 10)
	public void testMouseHover() throws Throwable {
		Actions act=new Actions(driver);
		WebElement mouseHoverButton=driver.findElement(By.cssSelector(getData("mouseHover.button")));
		act.moveToElement(mouseHoverButton).build().perform();

		WebElement top=driver.findElement(By.cssSelector(getData("mouseHover.top")));
		WebElement reload=driver.findElement(By.xpath(getData("mouseHover.reload")));
		if(top.isDisplayed() && reload.isDisplayed())
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@Test(priority = 11)
	public void testIFrame() throws Throwable {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,200)");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.cssSelector(getData("iframe.input"))).sendKeys(prop.getProperty("courseName"));
		driver.findElement(By.cssSelector(getData("iframe.search"))).click();
		JavascriptExecutor k=(JavascriptExecutor)driver;
		k.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		WebElement course=driver.findElement(By.xpath(getData("iframe.selectCourse")));
		course.click();
		WebElement courseTitle=driver.findElement(By.xpath(getData("iframe.courseTitle")));
			try {
				Assert.assertEquals(courseTitle.isDisplayed(), true);
			}
			catch(AssertionError e) {
				Assert.fail();
				System.out.println(e.toString());
			}
	}

}