package interviewQuestionsSeleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DifferentBetweenGetAndNavigateExample {

	@Test
	public void getAndNavigateDifference() {

		WebDriver driver = new ChromeDriver();


		//get method doesnot store history
		//get method will wait till all the elements are appearing in DOM
		driver.get("https://google.com");

		//NAvigate method will store history and hence we can apply methods like forward,back, refresh etc
		//navigate method WILL NOT wait till all the elements are appearing in DOM
		driver.navigate().to("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Enlightenment"+Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();







	}
}


