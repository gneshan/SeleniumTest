package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BottonExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		
		//Find position of button (x,y)
	    WebElement buttonPosition = driver.findElement(By.id("position"));
	    Point xyLocation = buttonPosition.getLocation();
	    int xlocation = xyLocation.getX();
	    int ylocation = xyLocation.getY();
	    System.out.println("The X location of the button is "+ xlocation );
	    System.out.println("The Y location of the button is "+ ylocation );
	    
	    //Find button color
	    WebElement buttonforColor = driver.findElement(By.id("color"));
	    String colorBotton = buttonforColor.getAttribute("style");
	    System.out.println("The background color of the Button is "+colorBotton);
	    
	    String bottonColor = buttonforColor.getCssValue("background-color");
	    System.out.println("The background color of the Button is "+bottonColor);
 
	    //Find the height and width
	   WebElement buttonDim =  driver.findElement(By.id("size"));
	   int height = buttonDim.getSize().getHeight();
	   int width = buttonDim.getSize().getWidth();
	   System.out.println("The height of the button is "+height);
	   System.out.println("The width of the button is "+width);
	   
		//Click button to travel home page
	   WebElement homeButton = driver.findElement(By.id("home"));
	   homeButton.click();
	    driver.close();

	}

}
