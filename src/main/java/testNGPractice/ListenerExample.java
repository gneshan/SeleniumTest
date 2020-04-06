package testNGPractice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListenerExample implements ITestListener {

	ExtentReports extent;
	ExtentTest testcase;	
	ExtentAventReporter avent;
	String workingDir;
	String imagePath,configXMLPath, reportFilePath, scrShotPath,datetimes,repName,tName;
	WebDriver driver;
	File srcPath, dstnPath;
	Boolean silent = null;
	Date date;
	SimpleDateFormat formatter;

	public void onTestStart(ITestResult result)
	{
		System.out.println("this is ontestStart");
	}

	public void onTestSuccess(ITestResult result)
	{
		tName=result.getMethod().getMethodName();
		System.out.println("The Test case " + tName + " is Passed");
		testcase=extent.createTest(result.getMethod().getMethodName());
		testcase.log(Status.PASS,MarkupHelper.createLabel("Woohoo@ Success! "+ tName + " is Passed",ExtentColor.GREEN));
	}


	public void onTestFailure(ITestResult result) 
	{
		try 
		{
			WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver"); //https://stackoverflow.com/questions/50923373/extent-report-3-add-screenshot/50945817#50945817
			tName=result.getMethod().getMethodName();
			System.out.println("The Test case " + tName + " is Failed");
			testcase=extent.createTest(result.getMethod().getMethodName());
			testcase.log(Status.FAIL, MarkupHelper.createLabel("oops! " + tName + " is Failed", ExtentColor.RED));
			scrShotPath = getScreenshot(driver, tName);
			System.out.println(scrShotPath);
			testcase.addScreenCaptureFromPath(scrShotPath, "Test");
			//testcase.addScreenCaptureFromPath(scrShotPath);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getMessage();
		}

	}

	public void onTestSkipped(ITestResult result) {
		tName=result.getMethod().getMethodName();
		System.out.println("The Test case " + tName + " is Skipped");
		testcase=extent.createTest(result.getMethod().getMethodName()).pass("This test case is passed");
		testcase.log(Status.SKIP, MarkupHelper.createLabel("OMG! " + tName + " is Skipped", ExtentColor.ORANGE));
	}

	public void onStart(ITestContext context) {
		System.out.println("I am going to start onStart method");
		date = new Date();
		formatter = new SimpleDateFormat("_MMddyyyyHHmmss");
		datetimes=formatter.format(date);
		extent= new ExtentReports();
		workingDir = System.getProperty("user.dir");
		repName="Test-Report_"+datetimes+".html";
		reportFilePath=workingDir+"/test-output/"+repName;
		System.out.println(reportFilePath);
		//extent.attachReporter(avent);
		ExtentHtmlReporter html = new ExtentHtmlReporter(reportFilePath);
		extent.attachReporter(html);
		html.loadXMLConfig("extent-config.xml");
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "gneshan@gmail.com");
		extent.setSystemInfo("Password", "Neshan#79");
		System.out.println(workingDir);
		// using the file path
		configXMLPath=workingDir+"/avent-config.xml";
		//File file = new File(configXMLPath);
		System.out.println(configXMLPath);
		//avent.loadXMLConfig("avent-config.xml");
		//avent.loadXMLConfig(workingDir+"\\SeleniumTest\\avent-config.xml");
		//avent.loadConfig("avent-config.xml");
	}

	public ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
		iTestContext.setAttribute("driver", driver);

		return iTestContext;
	}

	public String getScreenshot(WebDriver driver, String testName) throws Exception
	{
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		srcPath=screenShot.getScreenshotAs(OutputType.FILE);
		System.out.println(srcPath);
		imagePath=workingDir+"/ScreenShot/"+testName+datetimes+".PNG";
		System.out.println(imagePath);
		dstnPath=new File(imagePath);
		FileHandler.copy(srcPath, dstnPath);
		return imagePath;
	}

	public void onFinish(ITestContext context) {
		System.out.println("Signing off, Thank you Start!");
		extent.flush();
		//driver.quit();
		System.out.println("Signing off, Thank you!");
	} 
}






