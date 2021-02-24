package com.nit.cssselectors;

import com.nit.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstadingClassName  extends TestBase {
	
	@Test
	public void testApp() {
		WebDriver driver = launchBrowser("Chrome");
		driver.get("http://flipkart.com");
		//driver.findElement(By.className("_2zrpKA _1dBPDZ")).sendKeys("abc");  //InvalidSelectorException - means that mistake of a tester
		//In CSS - class represents look and feel of the element
		//By.className() -- In CSS selector - we can give only one class Name.. compund class Names are not permitted
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("hello");
		
	}

}
