package testscripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.LoginPage;


public class LoginTest {
	
	WebDriver driver;		
	
	@Test
	public void verifyLogin() throws InterruptedException {
		
		System.out.println("STEP: Launch Chrome Browser");
		
		PredefinedActions.start("https://syadav-trials711.orangehrmlive.com/");
		
		System.out.println("\nSTEP: Enter login credentials");
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.login("admin", "PyVDa@41nT");
		
		System.out.println("\nVERIFY: home page is displayed");
		
		String actualTitle = loginPage.getPageTitle();
		
		String expectedTitle = "Employee Management";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Expected title was '"+expectedTitle + "' but actual title is '"+ actualTitle+"'");
		
		PredefinedActions.closeBrowser();
		
	}
		
	
}
