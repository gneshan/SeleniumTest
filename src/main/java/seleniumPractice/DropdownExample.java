package seleniumPractice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");

		//Select Training program using Index
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select select = new Select(dropDown1);
		select.selectByIndex(1);

		//Select Training program using Text
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select select1 = new Select(dropDown2);
		select1.selectByVisibleText("Appium");

		//Select Training program using Value
		WebElement dropDown3 = driver.findElement(By.id("dropdown3"));
		Select select2 = new Select(dropDown3);
		select2.selectByValue("4");

		//Get # of dropdown Options
		WebElement optionDropdown = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/select"));
		Select select3 = new Select(optionDropdown);
		List<WebElement> dropdownList = select3.getOptions();
		int Size = dropdownList.size();
		System.out.println("The # of dropdown Options are "+ Size);

		//You can also use Send Keys to select
		WebElement dropdownSendkeys = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/select"));
		dropdownSendkeys.sendKeys("Appium");

		//Select multiple programs
		WebElement multiselect = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[6]/select"));
		Select multiSelectDropdown = new Select(multiselect);

		multiSelectDropdown.selectByIndex(1);	
		Thread.sleep(3000);
		multiSelectDropdown.selectByIndex(3);	
		multiSelectDropdown.selectByIndex(4);	






	}

}
