package interviewQuestionsSeleniumExamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

	WebDriver driver;
	@Test
	public void explicitWait() {

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']")).click();


		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement gotIt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookyGotItBtnBox']/child::div/button")));
		gotIt.click();
		WebElement profile=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='menu-vertical-01']/li[2]/a")));
		profile.click();

	}
}


