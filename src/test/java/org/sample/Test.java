package org.sample;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test extends BaseClass{

	public static void main(String[] args) {
		
	BaseClass b=new BaseClass();
	
	b.getDriver();
	b.launchUrl("https://www.facebook.com/");
	WebElement txtUsername = driver.findElement(By.id("email"));
	b.typeText(txtUsername, "prathap");
	WebElement txtPassword = driver.findElement(By.id("pass"));
	b.typeText(txtPassword, "prathap");
	WebElement btnclick = driver.findElement(By.name("login"));
	b.butnClick(btnclick);

	}

}
