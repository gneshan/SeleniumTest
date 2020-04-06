package testNGPractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomepageObjects;

public class FirstTestNGExample {

	public static WebDriver driver;

	@BeforeSuite
	public static void openGoogle() {


		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");


	}

	//Directly defining the findElements in Objectclass
	//	@Test(enabled=false)
	//	public static void Registration() {
	//		//Register in the MErcury tours site
	//		HomepageObjects.registerSite(driver).click();
	//		RegisterPageObjects.firstName(driver).sendKeys("Ganeshan");
	//		RegisterPageObjects.lastName(driver).sendKeys("KAruppaiyah");
	//		RegisterPageObjects.phone(driver).sendKeys("7326668931");
	//		RegisterPageObjects.email(driver).sendKeys("gneshan@gmail.com");
	//		RegisterPageObjects.addressField1(driver).sendKeys("11922, Burbank BLVD");
	//		RegisterPageObjects.addressField2(driver).sendKeys("Apt 25");
	//		RegisterPageObjects.city(driver).sendKeys("Valley Village");
	//		RegisterPageObjects.country(driver).sendKeys("UNITED STATES");
	//		RegisterPageObjects.uName(driver).sendKeys("gneshan");
	//		RegisterPageObjects.password(driver).sendKeys("Neshan#79");
	//		RegisterPageObjects.confirmPassword(driver).sendKeys("Neshan#79");
	//		RegisterPageObjects.submitButton(driver).click();
	//
	//		RegisterPageObjects.signInLink(driver).click();

	//	}


	@Test//(dependsOnMethods = "openGoogle") 
	public static void Login() {

		//Without using findElements and @FindBy Annotation. But the only limitation is 
		//the web page should have objects with id and name tags
		PageFactory.initElements(driver, HomepageObjects.class);
		HomepageObjects.userName.sendKeys("gneshan");
		HomepageObjects.password.sendKeys("Neshan#79");
		HomepageObjects.login.click();

		//Without using findElements but using @FindBy Annotation
		//		PageFactory.initElements(driver, HomepageObjects.class);
		//		HomepageObjects.uName.sendKeys("gneshan");
		//		HomepageObjects.pwd.sendKeys("Neshan#79");
		//		HomepageObjects.loginBtn.click();

		//Directly finding the findElements in object class
		//		HomepageObjects.userName(driver).sendKeys("gneshan");
		//		HomepageObjects.password(driver).sendKeys("Neshan#79");
		//		HomepageObjects.loginButton(driver).click();
	}
	
@AfterSuite
	public static void closeBrowser() {
		
	driver.close();
		
	}

}
