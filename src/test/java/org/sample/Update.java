package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Update {

	public static void main(String[] args) throws IOException {
		
	File f=new File("D:\\Automation\\Selenium\\MavenFrame\\ExcelRead\\Task.xlsx");
	
	FileInputStream fs=new FileInputStream(f);
	
	Workbook w= new XSSFWorkbook(fs);
	
	Sheet cs = w.createSheet("Update");
	
	Row cr = cs.createRow(0);
	
	Cell cc = cr.createCell(0);
	
	cc.setCellValue("varsha");
	
	FileOutputStream fo=new FileOutputStream(f);
	w.write(fo);
		
		

	}

}
