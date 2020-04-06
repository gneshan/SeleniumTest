package dataDrivenExample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.XLUtils;

public class DataDrivenWithTestNGDataProvidersAndXSSFXcel {

	WebDriver driver;
	String actualTitle;
	static String fileLocation;
	static String xlsheet;
	static String userData = null;
	static String PWD = null;
	static Object[][] credentials;
	static ArrayList<Object[]> myData = new ArrayList<Object[]>();
	static int rowCount;
	static int columnCount;
	static int iteration=1;

	@BeforeTest
	public void DriverScript(){

		driver = new FirefoxDriver();
		driver.get("https://www.phptravels.net/login");
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//String windowName = driver.getTitle();
		actualTitle = "Login";
		Assert.assertEquals(driver.getTitle(), actualTitle);
		System.out.println("Welcome to Login Window");
	}
	@AfterTest
	public void CloseScript() throws InterruptedException{
		
		//a[@class='dropdown-item tr']
		WebElement demoLink = driver.findElement(By.cssSelector(".dropdown-login > a:nth-child(1)"));
		demoLink.click();
		WebElement logoutLink = driver.findElement(By.xpath("//a[@class='dropdown-item tr']"));
		logoutLink.click();
		Thread.sleep(5000);
		driver.quit();
		//System.out.println("Test case ends here. Thanks!");
	}
	@Test(dataProvider = "testDataFromExcel")
	public void LoginTestCase(String uName, String PassWord) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(5000);


		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(uName);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(PassWord);
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit'][@class='btn btn-primary btn-lg btn-block loginbtn']"));
		loginButton.click();


		if(iteration<rowCount) {
			userName.clear();
			password.clear();
			WebElement errorText = driver.findElement(By.xpath("//*[@class='resultlogin']/child::div"));
			String text= errorText.getText();
			System.out.println(text);
			Assert.assertEquals(text, "Invalid Email or Password");
			iteration++;

		}


	}
	@DataProvider
	public static Object[][] testDataFromExcel(){

		fileLocation = "C:/Users/GSM/eclipse-workspace/SeleniumTest/data/TestData.xlsx";
		xlsheet = "UserCredentials";
		try {
			rowCount = XLUtils.getRowCount(fileLocation, xlsheet);
			//System.out.println(rowCount);
			columnCount = XLUtils.getCellCount(fileLocation, xlsheet, 1);

			credentials = new Object[rowCount][columnCount];
			for(int i=1;i<=rowCount;i++) {
				for(int j=0;j<columnCount;j++) {

					credentials[i-1][j] = XLUtils.getCellData(fileLocation, xlsheet, i, j);

				}
			}

		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return credentials;
	}

}
