package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");

		//I am inside a frame
		driver.switchTo().frame(0);
		WebElement frameButton = driver.findElement(By.id("Click"));
		frameButton.click();
		String buttonText = frameButton.getText();
		System.out.println(buttonText);

		//I am inside a nested frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement nestButton = driver.findElement(By.id("Click1"));
		nestButton.click();


		//Find total number of frames.
		driver.switchTo().defaultContent();
		List<WebElement> framesTotal = driver.findElements(By.tagName("iframe"));
		int size = framesTotal.size();
		System.out.println(size);
		
		
		









	}

}
