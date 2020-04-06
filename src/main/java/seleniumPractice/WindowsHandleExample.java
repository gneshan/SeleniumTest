package seleniumPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandleExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");

		String oldWindow = driver.getWindowHandle();
		//Click button to open home page in New Window
		WebElement homeButton = driver.findElement(By.id("home"));
		homeButton.click();

		Set<String> handles = driver.getWindowHandles();

		for (String newWindow : handles) {

			driver.switchTo().window(newWindow);

		}

		WebElement editButton = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a"));
		editButton.click();

		driver.close();
		driver.switchTo().window(oldWindow);

		//Find the number of opened windows
		WebElement allWindowButton = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		allWindowButton.click();
		
		int numberOfWindows = driver.getWindowHandles().size();
		System.out.println("Number of Open Windows are " + numberOfWindows);
		Set<String> allopenWindows = driver.getWindowHandles();
		for (String finalwindows : allopenWindows) {
			if(!finalwindows.equals(oldWindow)) {
				driver.switchTo().window(finalwindows);
				driver.close();
				
			}
			
		}
		
		//Close all except this window
		driver.switchTo().window(oldWindow);
		WebElement waitWindow = driver.findElement(By.xpath("//*[@id=\'color\']"));
		waitWindow.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int windowsCount = driver.getWindowHandles().size();
		System.out.println(windowsCount);
			
		//driver.quit();
	}

}
