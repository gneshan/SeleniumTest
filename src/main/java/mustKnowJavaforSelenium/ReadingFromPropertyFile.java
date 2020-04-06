package mustKnowJavaforSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingFromPropertyFile {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		FileInputStream fileinput = new FileInputStream("config.properties");

		Properties properties = new Properties();
		properties.load(fileinput);
		String browser = properties.getProperty("browser");
		String location = properties.getProperty("DriverLocation");

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",location );
			driver = new ChromeDriver();

		}
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Enlightment"+Keys.ENTER);

	}

}
