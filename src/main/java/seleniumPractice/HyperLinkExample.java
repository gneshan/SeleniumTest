package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperLinkExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		
		WebElement link = driver.findElement(By.linkText("Go to Home Page"));
		link.click();
		
		driver.navigate().back();
		
		
		WebElement whereIamGoing = driver.findElement(By.partialLinkText("where am"));
		String goToLink = whereIamGoing.getAttribute("href");
		System.out.println("The destination link is" + goToLink);
//		whereIamGoing.click();
		
//		driver.navigate().back();
		
		WebElement brokenLink = driver.findElement(By.partialLinkText("broken"));
		brokenLink.click();
		
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("404")) {
			System.out.println("This is Broken Link");
		}
		
		driver.navigate().back();
		
		WebElement link1 = driver.findElement(By.linkText("Go to Home Page"));
		link1.click();
		
		driver.navigate().back();
		
		WebElement gotoHompage2 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div/div/a"));
		gotoHompage2.click();
		
		driver.navigate().back();
		
		List<WebElement> numberOfLinks = driver.findElements(By.tagName("a"));
		int linksTotal = numberOfLinks.size();
		System.out.println("Total number of Links are " + linksTotal);
		//*[@id="contentblock"]/section/div[1]/div/div/a
		//*[@id="contentblock"]/section/div[4]/div/div/a
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
