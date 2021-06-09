package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	Actions ac;
	Robot r;
	Alert a;
	JavascriptExecutor js;
	Select s;

//it is used to initialize the Browser Condition	
	public void getDriver() {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// it is used for launch url
	public void launchUrl(String Url) {
		driver.get(Url);
	}

	// methods for sendkeys
	public void typeText(WebElement element, String data) {
		element.sendKeys(data);
	}

	// methods for click
	public void butnClick(WebElement element) {
		element.click();
	}

//method for getText
	public void printText(WebElement element) {
		element.getText();
	}

	// method for getAttribute
	public void printAttribute(WebElement element, String name) {
		element.getAttribute(name);
	}

	// method for Clear
	public void txtClear(WebElement element) {
		element.clear();
	}

	// method for isEnabled
	public void checkIsEnabled(WebElement element) {
		element.isEnabled();

	}

	// method for isDisplayed
	public void checkIsDisplayed(WebElement element) {
		element.isDisplayed();

	}

	// method for isSelected
	public void checkIsSelected(WebElement element) {
		element.isSelected();

	}

	// method for MoveToElement
	public void mouseHoverAction(WebElement target) {
		ac = new Actions(driver);
		ac.moveToElement(target).perform();
	}

	// method for DragandDrop
	public void dragAndDrop(WebElement source, WebElement target) {
		ac = new Actions(driver);
		ac.dragAndDrop(source, target).perform();
	}

	// method for ContextClick
	public void rightClick(WebElement target) {
		ac = new Actions(driver);
		ac.contextClick(target).perform();
	}

	// method for DoubleClick
	public void Doubleclick(WebElement target) {
		ac = new Actions(driver);
		ac.doubleClick(target).perform();
	}

	// Methods for KeyPress
	public void keyPress(int keycode) throws AWTException {
		r = new Robot();
		r.keyPress(keycode);
	}

	// Methods for KeyRelease
	public void keyRelease(int keycode) throws AWTException {
		r = new Robot();
		r.keyRelease(keycode);

	}

	// method for SimpleAlert
	public void alertSimple(WebElement element) {
		a = driver.switchTo().alert();
		a.accept();
	}

	// method for confirmAlert
	public void alertConfirm(WebElement element) {
		a = driver.switchTo().alert();
		a.accept();
		a.dismiss();
	}

	// method for promptAlert
	public void alertPrompt(WebElement element, String value) {
		a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();
	}

//method for JavascriptInsert
	public void javascriptInsert(WebElement element, String value, String data) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute(value,data)", element);

	}

	// method for JavascriptClick
	public void javascriptClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	// method for JavascriptGetAttributes
	public void javascriptGetAttributes(WebElement element, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute(value)", element);
	}

	// method for selectByIndex
	public void selectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);

	}

	// method for selectByValue
	public void selectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);

	}

	// method for selectByVisibleText
	public void selectByVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);

	}

	// method for getOptions
	public void getOptions(WebElement element) {
		s = new Select(element);
		s.getOptions();

	}

	public String getDataFromExcel(String pathname, String name, int rownum, int cellnum) throws IOException {
		File f = new File(pathname);
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(rownum);
		Cell c = r.getCell(cellnum);
		int ct = c.getCellType();
		String value="";
		if (ct==1) {
			value = c.getStringCellValue();
			
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
			String format = sd.format(dateCellValue);
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l= (long)numericCellValue;
			value = String.valueOf(1);
		}
		return value;
		

	}
	public WebElement findElementById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;

	}
	public WebElement findElementByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;

	}
	public WebElement findElementByClass(String className) {
		WebElement findElement = driver.findElement(By.className(className));
		return findElement;

	}
	public WebElement findElementByXpath(String xpathExpression) {
		WebElement findElement = driver.findElement(By.xpath(xpathExpression));
		return findElement;
}
	public List<WebElement> findElementsById(String id) {
		List<WebElement>  findElement = driver.findElements(By.id(id));
		return findElement;

	}
	public List<WebElement> findElementsByName(String name) {
		List<WebElement>  findElement = driver.findElements(By.name(name));
		return findElement;

	}
	public List<WebElement> findElementsByClass(String className) {
		List<WebElement> findElement = driver.findElements(By.className(className));
		return findElement;

	}
	public List<WebElement> findElementsByXpath(String xpathExpression) {
		List<WebElement> findElement = driver.findElements(By.xpath(xpathExpression));
		return findElement;
}
}