package interviewQuestionsSeleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DifferenceBetweenQuitandClose {
	WebDriver driver;
	@Test
	public void quitAndClose() {

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();

		//driver.close() method will close the instance which is in "driver's" focus  

		driver.get("http://leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[@id='home']")).click();
		//driver.close();

		//quit() method will close all windows of that driver's instance
		driver.quit();


	}

}
