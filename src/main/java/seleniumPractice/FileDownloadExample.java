package seleniumPractice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/download.html");
		//To Maximize the window
		driver.manage().window().maximize();
		//Click on the Download Link
		WebElement downloadLink = driver.findElement(By.linkText("Download Excel"));
		downloadLink.click();
		Thread.sleep(5000);
		//Going to the downloadpath
		File files = new File("C:\\Users\\GSM\\Downloads");
		//Gettting the total files in the folder and iterating through it to find the file
		File[] totalFiles = files.listFiles();
		for (File file1 : totalFiles) {

			if (file1.getName().equals("testleaf.xlsx")) {
				System.out.println("File is present");
				file1.delete();
				break;
			}



		}

		driver.close();


	}

}
