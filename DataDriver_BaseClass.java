package data_Driver_ExcelDatapasseedtoWebDriver.com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriver_BaseClass {

	public static WebDriver driver;

	public static void browser_launch() {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}

	public static void sendkeys(String mail, String pwd) {
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("pass")).sendKeys(pwd);
	}
	
	public static void clear() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
	}
	

}
