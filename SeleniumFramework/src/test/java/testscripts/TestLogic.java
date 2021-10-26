package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class TestLogic extends SeleniumUtility{

	@BeforeMethod
	public void startUp() {
		setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
	}
	
	@Test
	public void testSetupMethod() {
		System.out.println("Login page title: "+getCurrentTitleOfApplication());
		WebElement username=driver.findElement(By.id("username"));
		WebElement pwd=driver.findElement(By.id("password"));		
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Sign in']"));
		
		//typeInput(username, "admin");
		//typeInput(pwd, "Test@123");
				//or
		System.out.println("********************** USername: "+properties.getProperty("username"));
		typeInput(username, properties.getProperty("username"));		
		typeInput(pwd, properties.getProperty("password"));
		clickOnElement(loginButton);
		System.out.println("home page title: "+getCurrentTitleOfApplication());
		takeScreenShotOfThePage("./appScreenshots/homepage.png");
		
		clickOnElement(driver.findElement(By.cssSelector(".userName")));
		clickOnElement(driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
	}
	
	@AfterMethod
	public void tearDown() {
		cleapUp();
	}
}
