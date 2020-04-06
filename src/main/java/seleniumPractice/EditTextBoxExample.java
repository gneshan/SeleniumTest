package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditTextBoxExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		//Entering the email address in the first edit box
		WebElement emailBox = driver.findElement(By.id("email"));
		emailBox.sendKeys("TestingWord");
		//Append a text and press keyboard tab
		WebElement appendBox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/input"));
		appendBox.sendKeys("TestingWord"+Keys.TAB);		
		//Get default text entered
		WebElement editBoxText = driver.findElement(By.name("username"));
		String editBoxValue = editBoxText.getAttribute("value");
		System.out.println("The Value in the text box is "+editBoxValue);
		//Clear the text
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div/div/input")).clear();
		//Confirm that edit field is disabled
		WebElement disableBox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/div/div/input"));
		boolean isEnabledValue = disableBox.isEnabled();
		System.out.println(isEnabledValue);
		
		
		
		
	}

}
