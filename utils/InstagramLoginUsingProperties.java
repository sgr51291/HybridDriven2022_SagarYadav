package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class InstagramLoginUsingProperties {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		System.out.println("Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("https://www.instagram.com/");
		
		Thread.sleep(3000);
		
		System.out.println("Click on Sign Up link");
		driver.findElement(By.xpath("//a[@href='/accounts/emailsignup/']//span")).click();
		Thread.sleep(2000);
		
	}
	@Test
	public void loginInsta() throws InterruptedException {
		PropertiesFileReader prop = new PropertiesFileReader("src/propertyfile/instaLogin.properties");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@aria-label='Mobile Number or Email']")).sendKeys(prop.getValue("Mobile_Number"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@aria-label='Full Name']")).sendKeys(prop.getValue("Full_Name"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@aria-label='Username']")).sendKeys(prop.getValue("username"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(prop.getValue("password"));
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeAllBrowsers();
	} 

}
