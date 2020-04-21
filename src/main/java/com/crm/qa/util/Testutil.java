package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.crm.qa.base.Testbase;

public class Testutil extends Testbase {
	
	public static long Pageloadtimeout=100;
	public static long implicitwait=80;
	public static String TestData_Sheet_Path="C:\\Users\\Syed Danish\\Desktop\\CrmTestData.xlsx";
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static FileInputStream fls;
	//static Sheet sheet;

	public Testutil() {
		// TODO Auto-generated constructor stub
	}

	public void switchToFrame()
	{

		// Switch to frames 
		driver.switchTo().frame("mainpanel");
		
	}
	
	public static Object[][] getTestData(String sheetName) {
		//FileInputStream file;
		File src = new File(TestData_Sheet_Path);
		
		try {
			fls = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=new XSSFWorkbook(fls);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
/*		System.out.println(sheet.getLastRowNum() + "--------" +
		 sheet.getRow(0).getLastCellNum());*/
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
		


