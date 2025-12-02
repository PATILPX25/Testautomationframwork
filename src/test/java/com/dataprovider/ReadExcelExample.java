package com.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelExample {
	public static void main(String[] args) throws IOException {
		String excel_path = "C:\\Users\\ppatil88\\OneDrive - Capgemini\\Desktop\\data.xlsx";
		FileInputStream fis = new FileInputStream(excel_path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("xpath");

		int rao = sheet.getPhysicalNumberOfRows();
		XSSFRow rr = sheet.getRow(0);
		int column = rr.getLastCellNum();
		String xpathValue = "";

		System.out.println("Number of row" + rao + " number of column" + column);

		for (Row row : sheet) {
			for (Cell cell : row) {

				xpathValue = cell.getStringCellValue(); // Remove quotes
				System.out.println("xpath value are " + xpathValue);

			}

		}

	}
}