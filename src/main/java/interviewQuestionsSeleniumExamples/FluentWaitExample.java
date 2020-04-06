package interviewQuestionsSeleniumExamples;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitExample {

	WebDriver driver;
	@Test
	public void fluentWait() {
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']")).click();


		//Fluent Wait
		//Use the Wait Interface to create a new instance of FluentWait class
		//.withTimeout,.pollingEvery is deprecated so we have use Duration .ofseconds(30) method
		//inside wait.until(), we have to write custom function/method and the method should has to be named as "apply"

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(org.openqa.selenium.NoSuchElementException.class);

		WebElement profile=wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.xpath("//ul[@class='menu-vertical-01']/li[2]/a"));

			}
		});profile.click();
		driver.close();
	}
}
