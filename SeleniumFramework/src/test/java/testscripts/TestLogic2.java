package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class TestLogic2 extends SeleniumUtility{

	@BeforeMethod
	public void startUp() {
		setUp("chrome", "https://demo.actitime.com/login.do");
	}
	
	@Test
	public void testSetupMethod() {
		System.out.println("Login page title: "+getCurrentTitleOfApplication());
		WebElement username=driver.findElement(By.id("username"));
		WebElement pwd=driver.findElement(By.name("pwd"));		
		WebElement loginButton=driver.findElement(By.id("loginButton"));
		
		//typeInput(username, "admin");
		//typeInput(pwd, "Test@123");
				//or
		typeInput(username, properties.getProperty("username1"));		
		typeInput(pwd, properties.getProperty("password1"));
		clickOnElement(loginButton);
		
		takeScreenShotOfThePage("./appScreenshots/homepage.png");
		
		WebElement logout=driver.findElement(By.id("logoutLink"));
//		WebDriverWait wait=new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.elementToBeClickable(logout));
		//waitForElementToBeClickable(logout);
		System.out.println("home page title: "+getCurrentTitleOfApplication());
	}
	
	@AfterMethod
	public void tearDown() {
		cleapUp();
	}
}
