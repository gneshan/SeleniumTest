package dataDrivenExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenWithTestNGDataProviders {
	
	
	String [][] dataForLogin = {
			{"user@phptravels.com","demouser"},
			{"user@phptravels.com","demo"},
			{"user@phptravels.co","demouser"},
			{"user@phptravels.co","demouse"}		
			
		};
	
		
	@DataProvider(name="siteLogin")
	public String [][] loginData() {
		
		return dataForLogin;
	}
	
	
	@Test(dataProvider = "siteLogin" )
public void loginToApplication(String username, String password) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
	
	WebDriver driver = new ChromeDriver();
	String url = "https://www.phptravels.net/login";
	driver.get(url);
	
	driver.manage().window().maximize();
	
	//finding username field and entering the values
	WebElement uName = driver.findElement(By.xpath("//*[@id=\'loginfrm\']/div[3]/div[1]/label/input"));
	uName.sendKeys(username);
	
	//finding password field and entering the values
	WebElement pwd = driver.findElement(By.xpath("//*[@id=\'loginfrm\']/div[3]/div[2]/label/input"));
	pwd.sendKeys(password);
	
	//clicking on login button
	WebElement loginBtutton = driver.findElement(By.xpath("//*[@id=\'loginfrm\']/button"));
	loginBtutton.click();
	
	driver.quit();
}

}
