package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Calendar.html");

		WebElement dateSelector = driver.findElement(By.xpath("//*[@id='datepicker']"));
		dateSelector.click();
		
		WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
		nextButton.click();
		
		WebElement date = driver.findElement(By.xpath("//a[contains(text(),'10')]"));		
		date.click();
		
		//a[contains(text(),'10')]
		driver.close();
		
		
		
		
		
	}

}
