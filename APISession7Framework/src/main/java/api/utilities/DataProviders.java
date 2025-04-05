package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData(){
		String path=".\\testData\\Userdata.xlsx";
		ExcelUtil xl=new ExcelUtil(path);
		int rowNum=xl.getRowCount("sheet1");
		int cellCount=xl.getCellCount("sheet1", 1);
		String apiData[][]=new String[rowNum][cellCount];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<cellCount;j++) {
				apiData[i-1][j]=xl.getCellData("sheet1", i, j);
			}
		}
		return apiData;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() {
		String path=".\\testData\\Userdata.xlsx";
		ExcelUtil xl=new ExcelUtil(path);
		int rowNum=xl.getRowCount("sheet1");
		
		String apiData[]=new String[rowNum];
		for(int i=1;i<=rowNum;i++) {
			apiData[i-1]=xl.getCellData("sheet1", i, 1);
		}
		return apiData;
	}
}



















