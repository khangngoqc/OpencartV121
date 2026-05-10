package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtils xlUtil = new ExcelUtils(path); 
		
		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCols = xlUtil.getCellCount("Sheet1", 1);
		
		String  loginData[][] = new String[totalRows][totalCols]; //created for 2 dimension array which can store
		
		for (int i = 1; i <= totalRows; i++) //1 //read the data form xl sotring in two dimensional array
		{
			for (int j = 0; j < totalCols; j++) //0 i is row j is col
			{
				loginData[i-1][j] = xlUtil.getCellData("Sheet1", i, j); //1,0
			}
		}
		
		return loginData; //returning 2 dimension array
	
		 
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
	
	
}
