package com.expedia.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.expedia.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	
	public static String TESTDATA_SHEET_PATH = "/Users/yawenwang/eclipse-workspace/ExpediaTesting/src/main/java/com/expedia/qa/testdata/expediaTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println(sheet);
		 //System.out.println(sheet.getLastRowNum() + "--------" +
		  //sheet.getRow(0).getLastCellNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
//				HSSFCell.CELL_TYPE_STRING
//				System.out.println("xxxxx"+sheet.getRow(i + 1).getCell(k).getCellType());
				if(sheet.getRow(i + 1).getCell(k).getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					Format f = new SimpleDateFormat("MM/dd/yy");
					String strDate = f.format(sheet.getRow(i + 1).getCell(k).getDateCellValue());
//					System.out.println("WWWWWW"+strDate);
					data[i][k]=strDate;
				}else {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
				
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
