package seleniumPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileExample {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/upload.html");
		//To Maximize the window
		//driver.manage().window().maximize();

		//Thread.sleep(5000);
		//Clicking on the ChooseFile Button
		WebElement uploadButton = driver.findElement(By.name("filename"));
		//WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\'mydiv\']/input"));
		
		
//		Thread.sleep(5000);
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.ENTER).click().build().perform();
		uploadButton.click();
		
		Thread.sleep(5000);
		//Copying the uploading file path
		//Storing the path in a String
		String filePath = "C:\\Users\\GSM\\Downloads\\Test.xlsx";

		//Creating a Transferable Content String to text to pass to Toolkit class below
		StringSelection uploadFile = new StringSelection(filePath);		

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadFile, null);

		//To Simulate keyboard control on the windows

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);





	}

}
