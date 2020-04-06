package pageObjects;

import org.openqa.selenium.WebElement;

public class HomepageObjects {
	
	public static WebElement userName;
	public static WebElement password;
	public static WebElement login;
	
	//Without using findElement but using @FindBy Annotation
//	@FindBy(linkText="Register here")
//	public static WebElement registerlink;
//	
//	@FindBy(name="userName")
//	public static WebElement uName;
//	
//	@FindBy(name="password")
//	public static WebElement pwd;
//	
//	@FindBy(name="login")
//	public static WebElement loginBtn;
	
	// With using findElement
//	public static WebElement registerSite (WebDriver driver) {
//		WebElement registerlink =driver.findElement(By.linkText("Register here"));
//		return registerlink;
//			}
//	
//	public static WebElement userName(WebDriver driver) {
//		WebElement uName =driver.findElement(By.name("userName"));
//		return uName;
//			}
//
//	public static WebElement password (WebDriver driver) {
//		WebElement pwd =driver.findElement(By.name("password"));
//		return pwd;
//			}
//	public static WebElement loginButton (WebDriver driver) {
//		WebElement loginBtn =driver.findElement(By.name("login"));
//		return loginBtn;
//			}
}
