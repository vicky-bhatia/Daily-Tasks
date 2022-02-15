package com.vicky.Foundations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateLoginPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver and Selenium server\\chromedriver.exe");
		WebDriver obj1=new ChromeDriver();
		obj1.get("https://www.flipkart.com/");
		obj1.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("fornow1507@gmail.com");
		obj1.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("testing@123");
		obj1.findElement(By.xpath("(//span[text()=\"Login\"])[2]")).click();

	}

}
