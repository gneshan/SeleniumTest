package testNGPractice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsTestingSample {
	ExtentTest test;
	ExtentReports extent;
	Date date;
	SimpleDateFormat formatter;
	String datetimes,workingDir,repName,reportFilePath,windowName,imagePath;
	WebDriver driver;
	File srcPath,dstnPath;

	@BeforeMethod
	public void setUp()
	{
		date = new Date();
		formatter = new SimpleDateFormat("_MMddyyyyHHmmss");
		datetimes=formatter.format(date);
		workingDir = System.getProperty("user.dir");
		repName="Test-Report_"+datetimes+".html";
		reportFilePath=workingDir+"/test-output/"+repName;
		System.out.println(reportFilePath);
		extent= new ExtentReports();
		ExtentHtmlReporter html = new ExtentHtmlReporter(reportFilePath);
		//ExtentAventReporter avent = new ExtentAventReporter(reportFilePath);
		extent.attachReporter(html);
	}

	@Test
	public void testNGExtentReport(){
		{
			test = extent.createTest("Open Amazon");
			driver = new ChromeDriver();
			driver.get("https://amazon.com");
			windowName=driver.getTitle();
			System.out.println(windowName);
			Assert.assertEquals(windowName, "aAmazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenShotPath=getScreenShot("testNGExtentReport");
			test.addScreenCaptureFromPath(screenShotPath);
			test.fail("The testcase "+ result.getMethod().getMethodName() + "is failed" );
		}
		extent.flush();
		driver.quit();
	}

	public String getScreenShot(String testName) throws IOException 
	{

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		srcPath=screenShot.getScreenshotAs(OutputType.FILE);
		System.out.println(srcPath);
		imagePath=workingDir+"\\ScreenShot\\"+testName+datetimes+".PNG";
		System.out.println(imagePath);
		dstnPath=new File(imagePath);
		FileHandler.copy(srcPath, dstnPath);
		return imagePath;
	}
}
