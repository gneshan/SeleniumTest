package executableJarSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SimpleExecutableJarOpenGoogle {

	public static void main(String[] args) throws InterruptedException {

		
		String auto = "enlightenment now";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Enlightenent");
		Thread.sleep(2000);
		List<WebElement> autoComplete = driver.findElements(By.xpath("//ul[@jsname='erkvQe']/li/div/div[2]/div/span"));
		
		for (WebElement webElement : autoComplete) 
		{
			
			//Thread.sleep(2000);
			//System.out.println(auto);
			String text=webElement.getText();
			if(text.equals(auto))
			{
				webElement.click();
				break;
			}
		}
		String title=driver.getTitle();
		System.out.println(title);
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(title, "enlightenment now - Google Search");
		driver.quit();

	}

}
