package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

	public static void main(String[] args) throws InterruptedException {
		
		
	//Open the chrome browser
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://google.com");
	driver.findElement(By.name("q")).sendKeys("Enlightment"+Keys.ENTER);
    //driver.findElement(By.linkText("Go to Home Page")).click();
    //driver.findElement(By.partialLinkText("broken")).click();
	}
	
}