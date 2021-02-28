package com.nit.multipleobjectextraction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CNN {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\MyDevelopment\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://cnn.com");
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));  //Or By.xpath("//a")
		System.out.println("Total links "+ allLinks.size());
		
		WebElement fifthLink = allLinks.get(5);// webelement - 6th link ..list starts from index 0.
		System.out.println(fifthLink.getText());
		System.out.println(fifthLink.getAttribute("href"));
		//fifthLink.click();
		//Extraction starts from the Top left corner to the Bottom right..
		System.out.println(fifthLink.getLocation().x);
		System.out.println(fifthLink.getLocation().y);
		
		for(int i=0; i<allLinks.size(); i++) {
			WebElement link = allLinks.get(i);
			System.out.println(link.getText()+" --- "+ link.isDisplayed());
		}
	}
}
