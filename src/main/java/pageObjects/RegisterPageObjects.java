package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageObjects {

	//Contact Information
	public static WebElement firstName(WebDriver driver) {
		WebElement FName = driver.findElement(By.name("firstName"));
		return 	FName;
	}
	
	
	public static WebElement lastName(WebDriver driver) {
		WebElement LName = driver.findElement(By.name("lastName"));
		return LName;
	}
	
	public static WebElement phone(WebDriver driver) {
		WebElement phoneNumber = driver.findElement(By.name("phone"));
		return phoneNumber;
	}
	public static WebElement email(WebDriver driver) {
		WebElement emailId = driver.findElement(By.name("userName"));
		return emailId;
	}
	
	//Mailing Information
	public static WebElement addressField1(WebDriver driver) {
		WebElement addressOfGuest = driver.findElement(By.name("address1"));
		return addressOfGuest;
	}
	
	public static WebElement addressField2(WebDriver driver) {
		WebElement addressOfGuest1 = driver.findElement(By.name("address2"));
		return addressOfGuest1;
	}
	public static WebElement city(WebDriver driver) {
		WebElement cityName = driver.findElement(By.name("city"));
		return cityName;
	}
	
	
	public static WebElement state(WebDriver driver) {
		WebElement stateName = driver.findElement(By.name("state"));
		return stateName;
	}
	
	public static WebElement zip(WebDriver driver) {
		WebElement zipCode = driver.findElement(By.name("postalCode"));
		return zipCode;
	}
	
	public static WebElement country(WebDriver driver) {
		WebElement countryName = driver.findElement(By.name("country"));
		return countryName;
	}
	
	//User Information
	
	public static WebElement uName(WebDriver driver) {
		WebElement userName = driver.findElement(By.name("email"));
		return userName;
	}
	public static WebElement password(WebDriver driver) {
		WebElement pwd = driver.findElement(By.name("password"));
		return pwd;
	}
	public static WebElement confirmPassword(WebDriver driver) {
		WebElement cPass = driver.findElement(By.name("confirmPassword"));
		return cPass;
	}
	
	public static WebElement submitButton(WebDriver driver) {
		WebElement submit = driver.findElement(By.name("register"));
		return submit;
	}
	
	public static WebElement signInLink(WebDriver driver) {
		WebElement signin = driver.findElement(By.linkText(" sign-in "));
		return signin;
	}
	
	
	
	
}
