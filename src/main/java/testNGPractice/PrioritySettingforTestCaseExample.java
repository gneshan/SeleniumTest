package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PrioritySettingforTestCaseExample {

	public static WebDriver driver;

	@BeforeSuite
	public void driverInitialization(){
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 2)
	public void openGoogle() {
		driver.get("https://www.universalstudioshollywood.com");
	}
	
	@Test(priority = 1, enabled = false)
	public void openBing() {
		driver.get("https://www.bing.com");
	}

	@Test(priority = 0)
	public void openyahoo() {
		driver.get("https://www.yahoo.com/");
	}

	@Test(priority = -1, enabled = true)
	public void openrediff() {
		driver.get("https://www.rediff.com");
		
	}

	@AfterSuite
	public void closingBrowser() {
		driver.quit();
	}

}
