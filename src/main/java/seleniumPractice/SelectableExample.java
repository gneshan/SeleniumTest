package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableExample {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		
		List<WebElement> selectatbles = driver.findElements(By.xpath("//*[@id=\'selectable\']/li"));
		int sizeofselectables = selectatbles.size();
		System.out.println(sizeofselectables);
		
		//PRessing the CTRL Key and Selecting the list elements
		Actions actions = new Actions(driver);
//		actions.keyDown(Keys.CONTROL)
//			.click(selectatbles.get(0))
//			.click(selectatbles.get(1))
//			.click(selectatbles.get(2))
//			.build().perform();
		actions.clickAndHold(selectatbles.get(0))
		.clickAndHold(selectatbles.get(1))
		.clickAndHold(selectatbles.get(2))
		.release()
		.build().perform();
		
		
		
		

	}

}
