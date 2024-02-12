package data_Driver_ExcelDatapasseedtoWebDriver.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData_Passedto_WebDriver extends DataDriver_BaseClass {

	public static void main(String[] args) throws IOException {

		File Excel = new File("C:\\Users\\inbaraj\\eclipse-workspace\\Maven_TCF\\Username_Password.xlsx");

		FileInputStream Excel_Input = new FileInputStream(Excel);

		Workbook WB = new XSSFWorkbook(Excel_Input);

		Sheet sheet = WB.getSheet("Sheet1");

		int lastRowNum = sheet.getLastRowNum();
		browser_launch();

		for (int i = 0; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);
			short lastCellNum = row.getLastCellNum();

			Cell cell_1 = row.getCell(0);
			Cell cell_2 = row.getCell(1);

			System.out.println("First cell: " + cell_1 + ", " + "Second cell: " + cell_2);

			if (cell_1 != null || cell_2 != null) {
				CellType cell_Type_1 = cell_1.getCellType();
				CellType cell_Type_2 = cell_2.getCellType();
				if (cell_Type_1.equals(CellType.NUMERIC) || cell_Type_2.equals(CellType.NUMERIC)) {
					double numericCellValue1 = cell_1.getNumericCellValue();
					double numericCellValue2 = cell_2.getNumericCellValue();
				} else if (cell_Type_1.equals(CellType.STRING) || cell_Type_2.equals(CellType.STRING)) {
					String stringCellValue1 = cell_1.getStringCellValue();
					String stringCellValue2 = cell_2.getStringCellValue();
					clear();
					sendkeys(stringCellValue1, stringCellValue2);
				}
			}

		}
	}
}
