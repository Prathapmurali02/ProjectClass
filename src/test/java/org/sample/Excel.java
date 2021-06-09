package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {

File file=new File("D:\\Automation\\Selenium\\MavenFrame\\ExcelRead\\ExcelWork.xlsx");

FileInputStream stream = new FileInputStream(file);

Workbook book=new XSSFWorkbook(stream);

Sheet s = book.getSheet("Sheet1");
// to get particular value
//Row r = s.getRow(1);

//Cell c = r.getCell(0);
//String stringCellValue = c.getStringCellValue();
//System.out.println(stringCellValue);

// To get Full Value
// Outer for loop
for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
	Row r = s.getRow(i);
	//inner for loop
	for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
		Cell c = r.getCell(j);
		String stringCellValue = c.getStringCellValue();
		System.out.println(stringCellValue);
	}
	
}

	}

}
