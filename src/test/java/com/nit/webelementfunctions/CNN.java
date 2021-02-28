package com.nit.webelementfunctions;

import com.nit.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CNN extends TestBase {
	
	@Test
	public void cnn() {

			WebDriver driver = launchBrowser("Chrome");
			driver.get("http://cnn.com");// this will wait till 100% page load
			//isDisplayed() - assumes element is present - checks visibility
			boolean result = driver.findElement(By.xpath("//*[@id='header-nav-container']/div/div[2]/div/div[3]/nav/ul/li[3]/ul/li[1]/a")).isDisplayed();
			System.out.println("Visibility: "+ result);
			// click - visible
			driver.findElement(By.xpath("//*[@id='header-nav-container']/div/div[1]/div/button/svg")).click();

			result = driver.findElement(By.cssSelector("svg.menu-icon")).isDisplayed();
			System.out.println(result);
			System.out.println("Visibility after clicking: "+ result);
			driver.findElement(By.xpath("//*[@id='header-nav-container']/div/div[2]/div/div[3]/nav/ul/li[3]/ul/li[1]/a")).click();
	}
}
