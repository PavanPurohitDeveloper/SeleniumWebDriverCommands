package com.nit.implicitwait;


import java.util.concurrent.TimeUnit;

import com.nit.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitingExample extends TestBase {

	@Test
	public void linkedIn() throws InterruptedException {
		WebDriver driver = launchBrowser("Chrome");
		driver.get("https://www.linkedin.com/login?fromSignsession_passwordIn=true&trk=guest_homepage-basic_nav-header-signin");

		//Implicit wait is a dynamic wait - If unable to find the element this will wait maximum for 10 seconds..
		// within the 10 seocnds selenium will keep on finding the element continouusly on web page.
		// If element is found in 1 second , it wil use it and move forward.
		//This is global timeout - its applicable for all the driver.findElement() commands.
		//Write this line the moment you launch the browser.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait for sometime
		driver.findElement(By.id("usernameXX")).sendKeys("xyz");;
		driver.findElement(By.id("password")).sendKeys("xyz");;
	}
}
