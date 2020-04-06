package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");

		//Click the button to display a alert box
		WebElement alertBox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/button"));
		alertBox.click();
		Alert alertBoxswitch = driver.switchTo().alert();
		Thread.sleep(3000);
		alertBoxswitch.accept();

		//Click the button to display a confirm box.

		WebElement alertBox1 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		alertBox1.click(); 
		Alert confirmBox = driver.switchTo().alert();
		Thread.sleep(3000);
		confirmBox.dismiss();
		
		//Click on the PRompt Box
		WebElement promptBox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/button"));
		promptBox.click();
		Alert promptBoxalert = driver.switchTo().alert();
		promptBoxalert.sendKeys("Bulb");
		Thread.sleep(3000);
		promptBoxalert.accept();
		
		//Click the button to learn line-breaks in an alert.
//		WebElement lineBreakinprompt = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div/div/button"));
//		lineBreakinprompt.click();
//		Alert linebreakprompt = driver.switchTo().alert();
//		String linebreakText = linebreakprompt.getText();
//		Thread.sleep(3000);
//		System.out.println("The text in PromptBox is"+linebreakText);
//		promptBoxalert.accept();
		
		//Click the below button and click OK

		WebElement lineBreakinprompt = driver.findElement(By.xpath("//*[@id=\'btn\']"));
		lineBreakinprompt.click();
		//Alert linebreakprompt = driver.switchTo().alert();
		WebElement activePrompt = driver.switchTo().activeElement();
		String linebreakText = activePrompt.getText();
		Thread.sleep(3000);
		System.out.println("The text in PromptBox is "+ linebreakText);
		//linebreakprompt.accept();
		activePrompt.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/button")).click();
		
	}

}
