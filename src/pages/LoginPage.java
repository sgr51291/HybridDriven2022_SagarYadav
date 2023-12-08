package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class LoginPage extends PredefinedActions{
	
	public void login(String username, String password) {
		
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();		
		
	}
	
	public void enterUsername(String username) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		
		driver.findElement(By.xpath("//button")).click();
	}
	
	public boolean isUsernameErrorMessageDisplayed() {
		
		WebElement usernameErrorMessage = driver.findElement(By.cssSelector("txtUsername-error"));
		
		return usernameErrorMessage.isDisplayed();
	}
	
	public boolean isPasswordErrorMessageDisplayed() {
		
		WebElement passwordErrorMessage = driver.findElement(By.cssSelector("#txtPassword-error"));
		
		return passwordErrorMessage.isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		
		return  driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
}
