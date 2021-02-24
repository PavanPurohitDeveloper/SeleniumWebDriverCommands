package com.nit.cssselectors;

import com.nit.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkedIn extends TestBase {
	
	@Test
	public void linkedIn() {
		WebDriver driver = launchBrowser("Chrome");
		driver.get("https://www.linkedin.com/login?fromSignsession_passwordIn=true&trk=guest_homepage-basic_nav-header-signin");
		WebElement username = driver.findElement(By.cssSelector("input#username"));
		username.sendKeys("XYZ");
		System.out.println(username.getLocation().x);
		System.out.println(username.getLocation().y);
		
		
		String text = driver.findElement(By.xpath("html/body/div/main/div[2]/div[2]/h1")).getText();
		System.out.println(text);
		
		
		//WebElement password= driver.findElement(By.name("session_password"));
		//password.sendKeys("PASS");
		
		driver.findElement(By.name("session_password")).sendKeys("PASS");
		
		
		
		
		
		
		
	}

}
