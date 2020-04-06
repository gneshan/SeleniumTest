package seleniumPractice;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanmicTableExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSM\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		
		List<WebElement> columnsCount = driver.findElements(By.tagName("th"));
		int totalColumns = columnsCount.size();
		System.out.println("Total # of Columns are " + totalColumns);
		
		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		int totalRows = rowCount.size();
		System.out.println("Total # of Rows are " + totalRows);
		
		WebElement percent = driver.findElement(By.xpath("//td[ normalize-space()='Learn to interact using Keyboard, Actions']//following::td[1]"));
		String percentage = percent.getText();
		System.out.println(percentage);
		
		
		
		List<WebElement> columnList = driver.findElements(By.xpath("//td[2]"));
		
		List<Integer> numList = new ArrayList<Integer>();
		
		for (WebElement finalValue : columnList) {
			
			String minpercent = finalValue.getText().replace("%", "");
			numList.add(Integer.parseInt(minpercent));
									
		}
		
		System.out.println(numList);
		int minValue = Collections.min(numList);
		
		String smallValue = Integer.toString(minValue)+"%";
		System.out.println(smallValue);
		String finalXpath = "//td[normalize-space()=" + "\"" +smallValue+ "\""  +"]"+"//following::td[1]";
		System.out.println(finalXpath);
		Thread.sleep(5000);
		driver.findElement(By.xpath(finalXpath)).click();
//		selects.click();
		
		//driver.close();
	}
	

}
