package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonExample {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		
		//Selecting a radiobutton
		WebElement yesRadiobutton = driver.findElement(By.id("yes"));
		yesRadiobutton.click();
		
		//Find default selected radio button
		WebElement statusUnChecked = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/label[2]/input"));
		WebElement statusChecked = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/label[3]/input"));
	boolean status1 = statusUnChecked.isSelected();
	boolean status2 = statusChecked.isSelected();
	
	System.out.println("IS this unchecked ?"+ status1);
	System.out.println("IS this checked ?"+ status2);
	
	//Select your age group (Only if choice wasn't selected)
	WebElement Above40 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/input[3]"));
	Above40.click();
	
	}

}
