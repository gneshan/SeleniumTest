package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SimpleTestForListener {

	private ITestContext context;
	String windowName;
	WebDriver driver;
	
	//passing the driver as TestContext into listener
	//https://stackoverflow.com/questions/50923373/extent-report-3-add-screenshot/50945817#50945817
	public ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("driver", driver);

        return iTestContext;
    }
	
	@Test(priority = 1)
	public void OpenEbaySite(ITestContext iTestContext)
	{
		
		driver = new ChromeDriver();
		//passing the driver as TestContext into listener
		//Defining the driver as iTextContext
		//https://stackoverflow.com/questions/50923373/extent-report-3-add-screenshot/50945817#50945817
		this.context = setContext(iTestContext, driver);
		driver.get("https://ebay.com");
		windowName=driver.getTitle();
		System.out.println(windowName);
		Assert.assertEquals(windowName, "Electronics, Cars, Fashion, Collectibles & More | eBay");
				
	}
	
	@Test
	public void OpenAmazonSite(ITestContext iTestContext)
	{
		
		driver = new ChromeDriver();
		//passing the driver as TestContext into listener
		//Defining the driver as iTextContext
		//https://stackoverflow.com/questions/50923373/extent-report-3-add-screenshot/50945817#50945817
		this.context = setContext(iTestContext, driver);
		driver.get("https://amazon.com");
		windowName=driver.getTitle();
		System.out.println(windowName);
		Assert.assertEquals(windowName, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
				
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	
	}
	
}
