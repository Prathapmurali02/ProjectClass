package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AutomationTask {

	public static void main(String[] args) throws IOException  {
		
		File file=new File("D:\\Automation\\Selenium\\MavenFrame\\ExcelRead\\Task.xlsx");
		
		FileInputStream fs=new FileInputStream(file);
		
		Workbook wb= new XSSFWorkbook(fs);
		
		Sheet s = wb.getSheet("Sheet1");
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0;j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int ct = c.getCellType();
				if (ct==1) {
					String stringCellValue = c.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else if (DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sm=new SimpleDateFormat("dd-MMM-yyyy");
					String format = sm.format(dateCellValue);
					System.out.println(format);
					
				}
								
				else {
					double numericCellValue = c.getNumericCellValue();
					long l=(long)numericCellValue;
					System.out.println(l);
				}
				
				
			}
			System.out.println("*************");
		}
		

	}

}
