package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		
//Select the languages that you know?
WebElement checkValue1 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div[1]/input"));
WebElement checkValue2 =driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div[5]/input"));
checkValue1.click();
checkValue2.click();

//Confirm Selenium is checked
WebElement checkStatus = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/input"));
boolean status=checkStatus.isSelected();
if(status==true) {
	System.out.println("The checkbox is checked");
}
	//DeSelect only checked
	
	WebElement checkValue3 = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div[1]/input"));
	WebElement checkValue4 =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div[2]/input"));
	boolean status1=checkValue3.isSelected();
	boolean status2=checkValue4.isSelected();
	if(status1==true) {
		checkValue3.click();		
	}else {
		checkValue4.click();
		System.out.println("This checkbox is unchecked" + status2);
	}
	
	
	
//Select all below checkboxes
	driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[1]/input")).click();
	driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[2]/input")).click();	
	driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[3]/input")).click();
	driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[4]/input")).click();
	driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[5]/input")).click();

	
	
	}

}
