package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/autoComplete.html");
		
		driver.manage().window().maximize();
		 
		WebElement courseNameEditBox = driver.findElement(By.id("tags"));
		courseNameEditBox.sendKeys("s");
		Thread.sleep(5000);
		List<WebElement> autoCompleteList = driver.findElements(By.xpath("//*[@id=\'ui-id-1\']/li"));
		
		for (WebElement finalList : autoCompleteList) {
			
			String textonList = finalList.getText();
			System.out.println(textonList);
			if (textonList.equals("Web Services")) {
				//textonList.equals("Web Services");
				finalList.click();
				break;
			}
			
			
			
		}
		driver.close();


	}

}
