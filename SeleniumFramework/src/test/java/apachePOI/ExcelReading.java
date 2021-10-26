package apachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReading {

	@Test
	public void getSheetName() throws FileNotFoundException, IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\Test Cases for Vtiger.xlsx");
		// 2. Create an instance of required workbook
		XSSFWorkbook x = new XSSFWorkbook(fis);
		// 3. perform operation on sheet
		int sheetCount = x.getNumberOfSheets();// give you sheet count present inside excel
		System.out.println("Sheet count: " + sheetCount);
		System.out.println("Active sheet index: " + x.getActiveSheetIndex());
		for (int i = 0; i < sheetCount; i++) {
			System.out.println(x.getSheetName(i));
		}
	}

	@Test
	public void getRowOperation() throws IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\Test Cases for Vtiger.xlsx");
		// 2. Create an instance of required workbook
		XSSFWorkbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		XSSFSheet sheet = x.getSheet("Sheet1");
		// 4. get row
		int rowCount = sheet.getLastRowNum();// in current how many rows are present
		System.out.println("RowCount: " + rowCount);
	}

	@Test
	public void getCellOperation() throws IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\Test Cases for Vtiger.xlsx");
		// 2. Create an instance of required workbook
		XSSFWorkbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		XSSFSheet sheet = x.getSheet("Sheet1");
		// 4. get row
		XSSFRow row = sheet.getRow(0);
		// 5. cell operation
		System.out.println("Cell count in row-0: " + row.getLastCellNum());
		for (int i = 0; i < row.getLastCellNum(); i++) {
			System.out.println(row.getCell(i).getStringCellValue());
		}
	}

	@Test
	public void getDifferentCellValues() throws IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\Test Cases for Vtiger.xlsx");
		// 2. Create an instance of required workbook
		XSSFWorkbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		XSSFSheet sheet = x.getSheet("Sheet1");
		// 4. get row
		XSSFRow row = sheet.getRow(1);
		// 5. cell operation
		System.out.println("Cell count in row-0: " + row.getLastCellNum());
		for (int i = 0; i < row.getLastCellNum(); i++) {

			XSSFCell cell = row.getCell(i);
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				System.out.println(cell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				System.out.println((int) cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				System.out.println(cell.getBooleanCellValue());
				break;
			default:
				throw new RuntimeException("There is no support for this type of cell");
			}
		}
	}

	@Test
	public void getDifferentCellValues_2() throws IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\Test Cases for Vtiger.xlsx");
		// 2. Create an instance of required workbook
		Workbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		Sheet sheet = x.getSheet("Sheet1");
		// 4. get row
		Row row = sheet.getRow(1);
		// 5. cell operation
		System.out.println("Cell count in row-0: " + row.getLastCellNum());
		for (int i = 0; i < row.getLastCellNum(); i++) {

			Cell cell = row.getCell(i);
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				System.out.println(cell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				System.out.println((int) cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				System.out.println(cell.getBooleanCellValue());
				break;
			default:
				throw new RuntimeException("There is no support for this type of cell");
			}
		}
	}

	@Test
	public void getEachRowFirstCellValue() throws IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\SampleTestData.xlsx");
		// 2. Create an instance of required workbook
		Workbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		Sheet sheet = x.getSheet("Sheet1");
		// 4. get row count
		int rowCount=sheet.getLastRowNum();
		for(int i=0;i<rowCount;i++) {
//			Row row =sheet.getRow(i);
//			Cell cell=row.getCell(0);
					//or
//			Cell cell=sheet.getRow(i).getCell(0);
//			System.out.println(cell.getStringCellValue());
					//or
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		
	}
	@Test
	public void getEachRowAllCellValue() throws IOException {
		// 1. File location
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\SampleTestData.xlsx");
		// 2. Create an instance of required workbook
		Workbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		Sheet sheet = x.getSheet("Sheet1");
		// 4. get row count
		int rowCount=sheet.getLastRowNum();
		for(int i=0;i<rowCount;i++) {
				int cellCount=sheet.getRow(i).getLastCellNum();
				for(int j=0;j<cellCount;j++) {
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
				}
				System.out.println();
		}
		
	}
}
