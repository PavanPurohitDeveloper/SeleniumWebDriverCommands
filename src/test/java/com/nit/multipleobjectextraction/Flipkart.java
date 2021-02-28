package com.nit.multipleobjectextraction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {
	
	@Test
	public void printNames() {  //print the names of all the T-Shirts

		System.setProperty("webdriver.chrome.driver", "D:\\MyDevelopment\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/mens-clothing/tshirts/pr?sid=2oq,s9b,j9y&otracker=nmenu_sub_Men_0_T-Shirts");

		//List<WebElement> allTshirtNames = driver.findElements(By.xpath("//a[@class='_2mylT6']"));
		List<WebElement> allTshirtNames = driver.findElements(By.cssSelector("a._2mylT6"));
		System.out.println("total t shirts - "+allTshirtNames.size());

		//Iterate over all T-Shirts and prints the text.
		for(WebElement e: allTshirtNames) {
			System.out.println(e.getText());
		}
		
		List<WebElement> allTshirtPrices = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
		System.out.println("Total Prices "+allTshirtPrices.size());
		for(WebElement e: allTshirtPrices) {
			System.out.println(e.getText());
		}
		System.out.println("------------------");
		for(int i=0; i<allTshirtNames.size(); i++) {
			System.out.println(allTshirtNames.get(i).getText() +" --- "+ allTshirtPrices.get(i).getText());
		}
	}

}
