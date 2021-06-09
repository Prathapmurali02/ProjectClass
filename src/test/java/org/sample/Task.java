package org.sample;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class Task extends BaseClass{

	public static void main(String[] args) {
		
		BaseClass b=new BaseClass();
		
		b.getDriver();
		b.launchUrl("https://www.amazon.in/");
		WebElement txtSearch = b.findElementById("twotabsearchtextbox");
		b.typeText(txtSearch, "iphone");
		WebElement buttonClick = b.findElementById("nav-search-submit-button");
		b.butnClick(buttonClick);
		List<WebElement> price = b.findElementsByXpath("//span[@class='a-price-whole']");
		for (int i = 0; i < price.size(); i++) {
			String text = price.get(i).getText();
			System.out.println(text);
		}
		Set<WebElement>amount=new TreeSet<WebElement>(price);
		amount.addAll(price);
		for (WebElement x : amount) {
			System.out.println(x);
			
		}
		
		
			
		}
		
		
		}
		



