package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");

		WebElement Image = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/img"));
		Image.click();

		WebElement homeImage = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[4]/a/img"));
		homeImage.click();

		WebElement brokenImage = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/img"));
		if (brokenImage.getAttribute("naturalWidth").equals("0")) {
			System.out.println("Image is Broken");
		}
		//brokenImage.click();
		
//		WebElement homeImage1 = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[4]/a/img"));
//		homeImage1.click();
		Thread.sleep(5000);
		WebElement keyboardImage = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/img"));
		keyboardImage.click();
//		
//Actions action = new Actions(driver);
//action.keyDown(Keys.ENTER).click();

		
		
		 Thread.sleep(5000);
		 driver.close();
		 
	}

}
