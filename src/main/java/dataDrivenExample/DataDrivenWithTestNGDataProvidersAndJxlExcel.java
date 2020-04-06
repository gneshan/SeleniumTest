package dataDrivenExample;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenWithTestNGDataProvidersAndJxlExcel {

	WebDriver driver;
	String [][] data = null;


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://www.phptravels.net/login";
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@DataProvider(name = "loginDataSet")
	public String[][] dataForLoginFromExcel() throws BiffException, IOException {
		data = gettingDataFromExcel();

		return data;

	}

	public String[][] gettingDataFromExcel() throws BiffException, IOException {

		String excelLocation = "C:\\Users\\GSM\\Documents\\TestData.xls" ;
		FileInputStream file = new FileInputStream(excelLocation);

		Workbook workbook = Workbook.getWorkbook(file);
		String nameofSheet = "Sheet1";
		Sheet sheet = workbook.getSheet(nameofSheet);

		String[] sheetNames = workbook.getSheetNames();
		System.out.println(sheetNames);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();
		String cellValue[][] = new String[rowCount-1][columnCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {

				cellValue[i-1][j] = sheet.getCell(j, i).getContents();		
			}
		}
		return cellValue;		
	}


	@Test(dataProvider = "loginDataSet")
	public void loginTestCase(String username, String password) {

		//finding username field and entering the values
		WebElement uName = driver.findElement(By.xpath("//*[@id=\'loginfrm\']/div[3]/div[1]/label/input"));
		uName.sendKeys(username);

		//finding password field and entering the values
		WebElement pwd = driver.findElement(By.xpath("//*[@id=\'loginfrm\']/div[3]/div[2]/label/input"));
		pwd.sendKeys(password);

		//clicking on login button
		WebElement loginBtutton = driver.findElement(By.xpath("//*[@id=\'loginfrm\']/button"));
		loginBtutton.click();
		
		uName.clear();
		pwd.clear();
	}

}
