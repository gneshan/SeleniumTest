package dataDrivenExample;

import java.io.IOException;
import java.util.ArrayList;

import com.utils.XLUtils;

public class GetDataFromExcel {

	public static void main(String[] args) {


		String fileLocation;
		String xlsheet;
		String userData = null;
		String PWD = null;
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		fileLocation = "C:/Users/GSM/eclipse-workspace/SeleniumTest/data/TestData.xlsx";
		xlsheet = "UserCredentials";

		try {
			int rowCount = XLUtils.getRowCount(fileLocation, xlsheet);
			int columnCount = XLUtils.getCellCount(fileLocation, xlsheet, 1);
			int k=2;
			//Object[][] credentials = new Object[rowCount][columnCount];
			for(int i=1;i<=rowCount;i++) {
				for(int j=0;j<columnCount;j++) {


					if(k%2==0) {
						userData = XLUtils.getCellData(fileLocation, xlsheet, i, j);
						
						System.out.println("The UserName is " + userData);
						k++;
						
					}else {
						PWD = XLUtils.getCellData(fileLocation, xlsheet, i, j);
						System.out.println("The Password is " + PWD);
						k++;
					}Object ob[] = {userData,PWD};
					myData.add(ob);					
				}
			}

		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}
}

