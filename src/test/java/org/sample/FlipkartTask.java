package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTask {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtSearch.sendKeys("iphones 12",Keys.ENTER);
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
	File f=new File("D:\\Automation\\Selenium\\MavenFrame\\ExcelRead\\ExcelWork.xlsx");
	
	FileInputStream fs=new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(fs);
	
	Sheet s = w.createSheet("Amazon");
	
	for (int i = 0; i < products.size(); i++) {
		String text = products.get(i).getText();
		Row r = s.createRow(i);
		Cell c = r.createCell(0);
		c.setCellValue(text);
	}
	FileOutputStream fo=new FileOutputStream(f);
	w.write(fo);

	}

}
