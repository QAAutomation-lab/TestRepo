package testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropReadingTest {

	@Test
	public void propTest() throws IOException {

		String filePath=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\testData.properties";
		System.out.println("Current path: "+filePath);
		FileInputStream fis = new FileInputStream(filePath);
		System.out.println(fis.getFD());
		Properties prop = new Properties();

		prop.load(fis);
		
		if(!prop.getProperty("appUrl").equals(null)) {
		System.out.println("************ App URL: "+prop.getProperty("appUrl"));
		System.out.println("************ App Username: "+prop.getProperty("username"));
		System.out.println("************ App Password: "+prop.getProperty("pwd"));
		}else {
			System.out.println("Property file not read..");
		}
	}
	@Test
	public void propTest2() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		String filePath=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\testData.properties";
		System.out.println("Current path: "+filePath);
		FileInputStream fis = new FileInputStream(filePath);
		System.out.println(fis.getFD());
		Properties prop = new Properties();

		prop.load(fis);
		
		if(!prop.getProperty("appUrl").equals(null)) {
			driver.get(prop.getProperty("appUrl"));
		System.out.println("************ App URL: "+prop.getProperty("appUrl"));
		System.out.println("************ App Username: "+prop.getProperty("username"));
		System.out.println("************ App Password: "+prop.getProperty("pwd"));
		}else {
			System.out.println("Property file not read..");
		}
	}
}
