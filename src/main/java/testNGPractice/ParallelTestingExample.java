package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParallelTestingExample {
	
	public static WebDriver driver;
	

	@Test(priority = 1)
	public void openUSHDotCom()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.universalstudioshollywood.com");
		String expected=driver.getTitle();
		String actual="aUniversal Studios Hollywood - Los Angeles, California - Official Site";
		Assert.assertEquals(actual, expected);
//		if(expected.equals(actual)) 
//		{
//			Assert.assertTrue(true);
//			System.out.println("The testcase openUSH is passed");
//		}
//		else
//		{
//			Assert.assertTrue(false);
//			System.out.println("The testcase openUSH is Failed");
//		}driver.quit();
	}

	@Test(priority = 2)
	public void openAmazon()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String expected=driver.getTitle();
		System.out.println(expected);
		String actual="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		//SoftAssert softassert = new SoftAssert();//Softassertion is also called as Verify
		if(expected.equals(actual)) 
		{
			Assert.assertTrue(true);
			System.out.println("The testcase openAmazon is passed");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("The testcase openAmazon is Failed");
		}
		driver.quit();
	}

	@Test(priority = 3)
	public void openeBay()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		String expected=driver.getTitle();
		System.out.println(expected);
		String actual="Electronics, Cars, Fashion, Collectibles & More | eBay";
		if(expected.equals(actual)) 
		{
			Assert.assertTrue(true);
			System.out.println("The testcase openEbay is passed");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("The testcase openEbay is Failed");
		}
		driver.quit();
	}
	
//	@AfterSuite
//	public void teardown()
//	{
//		System.out.println("Entering AfterTest Method");
//		driver.quit();
//	}

}
