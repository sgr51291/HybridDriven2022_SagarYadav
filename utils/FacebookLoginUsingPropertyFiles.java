package utils;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class FacebookLoginUsingPropertyFiles {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		System.out.println("Launch Chrome Browser and hit URL");
		
		driver = PredefinedActions.start("https://www.facebook.com/");
		
		System.out.println("Click on Create New Account Button");
		
		driver.findElement(By.xpath("//div[@class='_6ltg'][2]/a")).click();
		
		Thread.sleep(3000);
	}
	
	@Test
	public void facebookSignUp() throws Exception{
		
		PropertiesFileReader prop = new PropertiesFileReader("src/propertyfile/fbLogin.properties");
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getValue("First_Name"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getValue("Surname"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getValue("Mobile_Number"));
		Thread.sleep(1000);
		
		driver.findElement(By.id("password_step_input")).sendKeys(prop.getValue("new_password"));
		Thread.sleep(1000);
		
		WebElement date = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(date);
		dateSelect.selectByValue(prop.getValue("date"));
		Thread.sleep(1000);
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(month);
		monthSelect.selectByValue(prop.getValue("month"));
		Thread.sleep(1000);
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(year);
		yearSelect.selectByVisibleText(prop.getValue("year"));
		Thread.sleep(1000);
		
		WebElement gender = driver.findElement(By.xpath("//span[@data-name='gender_wrapper']/span[2]/input"));
		gender.click();

		
		Thread.sleep(5000);
		
		
		
		
				
	}
	
	@AfterMethod
	void tearDown() {
		PredefinedActions.closeBrowser();
	}

}
